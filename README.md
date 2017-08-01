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

### Stored XSS Attacks:
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
	
### Reflected XSS Attacks:
Reflected XSS are injected **non-persistent** scripts that got reflected off the web server (error message, search result, etc.). The reason these attacks are called reflected is because the user must click a link, or submit a form, or visit a link for the injected code to travel to vulnerable site then reflects the attack to the user's browser.

Try this example here to have a better understanding of reflected XSS attacks.

* **Step 1**: Change dir to the reflected XSS file. In my case:

	```
	$ cd ~/Documents/Coding/repos/xss-tutorial/reflected-XSS-example
	```

* **Step 2**: Run the example website with Gradle:

 	```			
	$ gradle jettyRun
	```
* **Step 3**: You will see something like this

![](http://i.imgur.com/iyjKrkR.png)

* **Step 4**: Again, play around with it. Enter your name, the site will say hello to you

![](http://i.imgur.com/KQg24MS.png)

* **Step 5**: Now try XSS on this site by opening the bold tag. You should expect to see the testing text turns into bold since we didn't close the bold tag.

![](http://i.imgur.com/9iR3ayH.png)

* **Step 6**: Now let's try to inject script in here

![](http://i.imgur.com/7RDhemq.png)

![](http://i.imgur.com/GiFkOkL.png)

You might see that it doesn't work. Simply because some browsers have protection against XSS. If you wish to know more about these things, here is a discussion on [how Chrome is secured against Reflected XSS](https://security.stackexchange.com/questions/53474/is-chrome-completely-secure-against-reflected-xss)

For the purpose of this tutorial, you should click **visiting the site's homepage**.

![](http://i.imgur.com/h1E8NGm.png)

Then click the link above.

The result?:

![](http://i.imgur.com/mqCkLdF.png)

### Malicious scripts

These examples above use the generic alert scripts to serve the purpose of understanding of how XSS works. But what do malicious scripts look like or what can they do?

The most severe attacks aim to steal the user's session cookie. The attacker can easily steal your accounts and information from the cookie. Besides stealing cookies, they have the ability to install Trojan programs, redirect user to other site or change the content of your site.

For a more hand-on experience with how the malicious scripts work, visit this Youtube page and watch this very intuitive video on this subject[ by DrapsTV.](https://www.youtube.com/watch?v=Iu3QtMy9cpg)

# How to prevent the attacks

To prevent an attack, we need to know the filters for our website and how attackers could bypass those filters.

Sites could escape before inserting untrusted data into HTML content. They would do that by converting a certain characters used in scripts such as >, <, ", ', /, &, etc. into HTML entities or hex entities. Those entities basically means that a < would appear as ```&lt;``` instead. For more entities, visit a site on [HTML entities](https://www.w3schools.com/html/html_entities.asp). 

However, attackers could inject something like ```<script>alert(String.fromCharCode(88,83,83));</script>``` and get the same result as ```<script>alert("XSS");</script>``` without being detected. What we can do to prevent this is to block out all the script tags &lt;script&gt; to begin with. Sometimes, that filter wouldn't help you neither since javascript can be ran off the browser's address bar by injecting something like ```<a> href=javascript:alert(String.fromCharCode(88,83,83)) Click</a>```. This script will show up in the site as a link that will alert XSS to the brower.

![](http://i.imgur.com/x7KGNoS.png)

![](http://i.imgur.com/iiMLB27.png)

To learn more on how to protect XSS on your site, visit the OWASP XSS Prevention [Cheat Sheet](https://www.owasp.org/index.php/XSS_(Cross_Site_Scripting)_Prevention_Cheat_Sheet).



# Credits

Thanks to DrapsTV Youtube channel and OWASP article on XSS for inspiring me to make this tutorial.
