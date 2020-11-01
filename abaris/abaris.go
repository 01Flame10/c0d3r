package main

import (
	"fmt"
	"bytes"
	"io"
	"io/ioutil"
	"bufio"
	"os"
	"log"
	"os/exec"
	"sync"
	"strings"
	"strconv"
	"net/http"
	"net/url"
)

const (
	MAXBUFFER = 32768
	envName = "MY_TEST_ENV_VARIABLE"
)

var filenames [1024]string
var executableFilenames [1024]string
var numfiles int = 0 
var source []byte
var todo int = 0
var language int = 0
var successOutput string = ""
var successAutotest int = 0

func main() {

	params := os.Args[1:]
	if len(params) == 0 || checkFlag("-h", params) == true {

		showHelp("-h")
		if len(params) == 0 {

			fmt.Println("Starting the server...")

			http.HandleFunc("/process", handleProcess)

			log.Fatal(http.ListenAndServe("localhost:8000", nil))
		}
	} else {

		showConsoleHeader()

		fmt.Println("Run abaris with -h flag to get help.")
		fmt.Println(" ")

		if checkFlag("-v", params) == false { // processing request

			var flagIndex int
			flagFound := false

			for flagIndex = 0; flagIndex < len(params); flagIndex++ {

				if isFlag(params[flagIndex]) == false {
					if flagFound == false {
						filenames[numfiles] = params[flagIndex]
						numfiles++
					} else {
						fmt.Println("[Error] Unknown flag: " + params[flagIndex])
					}
				} else {
					flagIndex = parseFlag(params[flagIndex], params, flagIndex)
					flagFound = true
				}
			}

			for f := 0; f < numfiles; f++ {

				var err error
				source , err = ioutil.ReadFile(filenames[f])
				if err != nil {
					fmt.Printf("[Error] %v\n ", err)
					continue
				}
            }
 
    	    if language == 1 {
    			ProcessRequest([]string {"g++", filenames[0]})
				ProcessRequest2([]string {executableFilenames[0], ""})
    		} else if language == 2 {
    			ProcessRequest([]string {"javac", filenames[0]})
				ProcessRequest2([]string {"java", executableFilenames[0]})
    		}
           
            fmt.Println("OK!")
		} else { // checking source code file format
	     
		}
	}
}

func handleProcess(w http.ResponseWriter, r *http.Request) {

	r.ParseForm()
    
    strComponents := strings.Split(r.FormValue("data"), "|")
    if len(strComponents) > 4 {
    
    	todo, err := strconv.Atoi(strComponents[0])
    	if err != nil {
			log.Fatalln(err)
		}

    	language, err := strconv.Atoi(strComponents[1])
    	if err != nil {
			log.Fatalln(err)
		}
		
		successOutputDecoded, err := url.QueryUnescape(strComponents[2])
	    if err != nil {
		    log.Fatalln(err)
    	}
    	
    	successOutput = successOutputDecoded

    	var o string = ""

    	for f := 3; f < len(strComponents); f += 3 {

    		o = fetchFile(strComponents[f]);
    		
			err = ioutil.WriteFile(strComponents[f+1], []byte(o), 0777)
			if err != nil {
				log.Fatalln(err)
			}
			
			filenames[numfiles] = strComponents[f+1];
			executableFilenames[numfiles] = strComponents[f+2];
			numfiles++
    	}
    	
    	if language == 1 {
    		ProcessRequest([]string {"g++", filenames[0]})
			ProcessRequest2([]string {executableFilenames[0], ""})
    	} else if language == 2 {
    		ProcessRequest([]string {"javac", filenames[0]})
			ProcessRequest2([]string {"java", executableFilenames[0]})
    	}
    	
    	// fmt.Fprintln(w, strconv.Itoa(todo) + " " + strconv.Itoa(language) + " " + strComponents[0] + " " + strComponents[1] + " " + o)

		if successAutotest == 1 {

        	fmt.Fprintln(w, "OK!|AutotestSuccess|" + strconv.Itoa(todo) + "|" + strconv.Itoa(language))
        } else {

        	fmt.Fprintln(w, "OK!|AutotestFailed|" + strconv.Itoa(todo) + "|" + strconv.Itoa(language))        
        }
    } else {
    
    	fmt.Fprintln(w, "ERROR|No data provided.")
    }
}

func fetchFile(filename string) string {

	var strOutput string

	client := http.Client{} 
	resp, err := client.Get(filename) 
	if err != nil { 
		log.Fatalln(err) 
	} 
	defer resp.Body.Close()

	scanner := bufio.NewScanner(resp.Body)
    for i := 0; scanner.Scan(); i++ {
        strOutput += scanner.Text()+"\n"
    }

    if err := scanner.Err(); err != nil {
        log.Fatalln(err)
    }
    
    return strOutput;
}

func ProcessRequest(commands []string) {

    // cmd := exec.Command("javac", filenames[0])
    cmd := exec.Command(commands[0], commands[1])

	var stdoutBuf, stderrBuf bytes.Buffer
	stdoutIn, _ := cmd.StdoutPipe()
	stderrIn, _ := cmd.StderrPipe()

	var errStdout, errStderr error
	stdout := io.MultiWriter(os.Stdout, &stdoutBuf)
	stderr := io.MultiWriter(os.Stderr, &stderrBuf)
	err := cmd.Start()
	if err != nil {
		log.Fatalf("cmd.Start() failed with '%s'\n", err)
	}

	var wg sync.WaitGroup
	wg.Add(1)

	go func() {
		_, errStdout = io.Copy(stdout, stdoutIn)
		wg.Done()
	}()

	_, errStderr = io.Copy(stderr, stderrIn)
	wg.Wait()

	err = cmd.Wait()
	if err != nil {
		// log.Fatalf("cmd.Run() failed with %s\n", err)
		fmt.Printf("cmd.Run() failed with %s\n", err)
	}
	if errStdout != nil || errStderr != nil {
		log.Fatal("failed to capture stdout or stderr\n")
	}
	
	outStr, errStr := string(stdoutBuf.Bytes()), string(stderrBuf.Bytes())
	fmt.Printf("\nout:\n%s\nerr:\n%s\n", outStr, errStr)
}

func ProcessRequest2(commands []string) {

    // cmd := exec.Command("java", "HelloWorld")
    // cmd := exec.Command("java", executableFilenames[0])
    cmd := exec.Command(commands[0], commands[1])

	var stdoutBuf, stderrBuf bytes.Buffer
	stdoutIn, _ := cmd.StdoutPipe()
	stderrIn, _ := cmd.StderrPipe()

	var errStdout, errStderr error
	stdout := io.MultiWriter(os.Stdout, &stdoutBuf)
	stderr := io.MultiWriter(os.Stderr, &stderrBuf)
	err := cmd.Start()
	if err != nil {
		log.Fatalf("cmd.Start() failed with '%s'\n", err)
	}

	var wg sync.WaitGroup
	wg.Add(1)

	go func() {
		_, errStdout = io.Copy(stdout, stdoutIn)
		wg.Done()
	}()

	_, errStderr = io.Copy(stderr, stderrIn)
	wg.Wait()

	err = cmd.Wait()
	if err != nil {
		// log.Fatalf("cmd.Run() failed with %s\n", err)
		fmt.Printf("cmd.Run() failed with %s\n", err)
	}
	if errStdout != nil || errStderr != nil {
		log.Fatal("failed to capture stdout or stderr\n")
	}
	
	outStr, errStr := string(stdoutBuf.Bytes()), string(stderrBuf.Bytes())
	fmt.Printf("\nout:\n%s\nerr:\n%s\n", outStr, errStr)
	
	// fmt.Println("successOutput:" + successOutput)
	// fmt.Println("outStr:" + outStr)
	// fmt.Printf("successOutput: %v \n", []byte(successOutput))
	// fmt.Printf("outStr: %v \n", []byte(outStr))
	
	if strings.Compare(strings.TrimSpace(successOutput), strings.TrimSpace(outStr)) == 0 {
	
		fmt.Println("Success! Autotest passed.")
		successAutotest = 1
	} else {
	
		fmt.Println("Fail! Autotest failed.")
		successAutotest = 0
	}
}

func checkFileExists(f string) {

    path, err := exec.LookPath(f)
    if err != nil {
        fmt.Printf("Couldn't find " + f + " executable.\n")
    } else {
        fmt.Printf(f + " executable is in '%s'\n", path)
    }
}

func checkFlag(s string, p []string) bool {

	for _, arg := range p {
		if arg == s {
			return true
		}
	}
	return false
}

func isFlag(s string) bool {

	var allFlags []string = []string{"-h", "-v", "-lj", "-lc", "-lp", "-lg", "-ly", "-r"}
	for _, f := range allFlags {
		if f == s {
			return true
		}
	}
	return false
}

func parseFlag(flag string, allParams []string, currentFlagIndex int) int {

	if flag == "-r" {
		todo = 1
		return currentFlagIndex+1
	}

	if flag == "-lj" {
		language = 1
		return currentFlagIndex+1
	}

	return 1000
}

func showConsoleHeader() {

	fmt.Println(" ")
	fmt.Println("*******************************************************")
	fmt.Println("Abaris 1.0 Remote Compiler Tool")
	fmt.Println("*******************************************************")
	fmt.Println("Copyright (c) 2020 COSMOTEQ")
	fmt.Println("Visit cosmoteq.com for the latest software release")
	fmt.Println(" ")
}

func showHelp(flag string) {

	if flag == "-h" {

		showConsoleHeader()

		fmt.Println("Basic usage: abaris [source filename] [optional source filename] [flags]")
		fmt.Println(" ")
		fmt.Println("Supported flags:")
		fmt.Println(" ")
		fmt.Println("-h\t\tHelp")
		fmt.Println("-h [flag]\tHelp on particular flag usage")
		fmt.Println("-v\t\tValidate source code files format")
		fmt.Println("-lj\t\tSet Java language")
		fmt.Println("-lc\t\tSet C/C++ language")
		fmt.Println("-lp\t\tSet Pascal language")
		fmt.Println("-lg\t\tSet Go language")
		fmt.Println("-ly\t\tSet Python language")
		fmt.Println("-r\t\tCompile and run source codes")
		fmt.Println(" ")
	}
}
