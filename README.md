# Cross Site Scripting Tutorial

# What is Cross Site Scripting?
Cross Site Scripting (XSS) attacks are code injection, in which malicious scripts are injected in a website. The scripts can access cookies, session tokens, make the users complete certain actions with the browser, or change/rewrite the content of the HTML page.
XSS attacks are the most common website attacks, followed by SQL injection and file upload. Therefore, this tutorial will help you learn about types of XSS attacks and how to prevent them.

For example, when I open a tag in HTML and not close it, all the following content will be affected by that tag. In this example, I'll be using the &lt;i&gt; *tag. As you can see, everything after the open &lt;i&gt; tag will be shown as italics text.Therefore, unless I close the &lt;i&gt; tag, the content of my HTML page will be changed into italics font.* &lt;&#47; i&gt; There we go, that's better. For this example, I had to use the HTML entities since the tag will affect how you view the document. We will come back to HTML entities in **How to prevent the attacks** part.

# Types of XSS attacks
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

###Stored XSS Attacks:
Stored XSS are permanently injected in the database, the comment field, etc. These injected scripts are recently called **persistent scripts**. Go ahead and try injecting scripts in the website. Here are the steps:

    
* **Step 1**: Change dir to the stored XSS example file. In my case:   		
	
	```
	$ cd ~/Documents/Coding/repos/xss-tutorial/stored-XSS-example
	```

* **Step 2**: Run the example website with Gradle

	```			
	$ gradle jettyRun
	```
* **Step 3**: You will see something like this

![](http://i.imgur.com/lM5BycA.png)

* **Step 4**: Play around with it. Comment something, use HTML tags too (e.g 	&lt;b&gt;Something	&lt; /b&gt;)

![](http://i.imgur.com/7lij9gW.png)

* **Step 5**: Now try XSS on this site

![](http://i.imgur.com/aHl8bIY.png)

* **Step 6**: And see the result. Now you will see every comment below "Open but don't close" turns into bold font because we did not close the bold tag.

![](http://i.imgur.com/J95gyq0.png)

* **Step 7**: Close the tag and see the result of our XSS.

![](http://i.imgur.com/vQVQAfV.png)

![](http://i.imgur.com/58LUsJX.png)

* **Step 8**: Now we see how people use scripts on the site

![](http://i.imgur.com/aJkcyGD.png)

![](http://i.imgur.com/aO6zA0h.png)

**Conclusion:** As I'd mentioned before, these attacks are called stored XSS because these scripts will permanently stay on the site. As soon as you open this site, you will immediately be alerted every time. However, instead of just alerting, people can change your site's contents, redirect users to other sites, etc.
	
###Reflected XSS Attacks:
Reflected XSS are injected **non-persistent** scripts that got reflected off the web server (error message, search result, etc.).


# How to prevent the attacks

