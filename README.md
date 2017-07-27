# Cross Site Scripting Tutorial

## What is Cross Site Scripting?
Cross Site Scripting (XSS) attacks are code injection, in which malicious scripts are injected in a website. The scripts can access cookies, session tokens, make the users complete certain actions with the browser, or change/rewrite the content of the HTML page.
XSS attacks are the most common website attacks, followed by SQL injection and file upload. Therefore, this tutorial will help you learn about types of XSS attacks and how to prevent them.

For example, when I open a tag in HTML and not close it, all the following content will be affected by that tag. In this example, I'll be using the &lt;i&gt; *tag. As you can see, everything after the open &lt;i&gt; tag will be shown as italics text.Therefore, unless I close the &lt;i&gt; tag, the content of my HTML page will be changed into italics font.* &lt;&#47; i&gt; There we go, that's better. For this example, I had to use the HTML entities since the tag will affect how you view the document. We will come back to HTML entities in **How to prevent the attacks** part.

## Types of XSS attacks
First, to be interactive with this tutorial, you need to clone the repository to your local directory.

Initially, I'll change the directory to my desired local file.

```
$ cd ~/Documents/Coding/repos
```

Then clone the repository

```
$ git clone https://github.com/TomMLe/xss-tutorial.git
```

Generally, there are two types of malicious scripts - persistent scripts and non-persistent scripts. A much less well-known type is called DOM Based XSS. 

1. **Stored XSS Attacks** 
Stored XSS are permanently injected in the database, the comment field, etc. These injected scripts are recently called **persistent scripts**. Go ahead and try injecting scripts in the website. Here are the steps:

    * Step 1: Change dir to the stored XSS example file. In my case:   		
		
		```
		$ cd ~/Documents/Coding/repos/xss-tutorial/stored-XSS-example
		```

    * Step 2: Run the example website with Gradle

		```			
		$ gradle jettyRun
		```
	* Step 3: You will see something like this

2. **Reflected XSS Attacks**

## How to prevent the attacks


