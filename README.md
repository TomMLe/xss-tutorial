# Cross Site Scripting Tutorial
------
## What is Cross Site Scripting?
Cross Site Scripting (XSS) attacks are code injection, in which malicious scripts are injected in a website. The scripts can access cookies, session tokens, make the users complete certain actions with the browser, or change/rewrite the content of the HTML page.
XSS attacks are the most common website attacks, followed by SQL injection and file upload. Therefore, this tutorial will help you learn about types of XSS attacks and how to prevent them.

For example, when I open a tag in HTML and not close it, all the following content will be affected by that tag. In this example, I'll be using the &lt;i&gt; *tag. As you can see, everything after the open &lt;i&gt; tag will be shown as italics text.Therefore, unless I close the &lt;i&gt; tag, the content of my HTML page will be changed into italics font.* &lt;i&gt;. There we go, that's better. For this example, I had to use the HTML entities since the tag will affect how you view the document. We will come back to HTML entities in **How to prevent the attacks** part.

## Types of XSS attacks
Generally, there are two types of malicious scripts - persistent scripts and non-persistent scripts. A much less well-known type is called DOM Based XSS. 
1. **Stored XSS Attacks** 
2. **Reflected XSS Attacks**

## How to prevent the attacks


