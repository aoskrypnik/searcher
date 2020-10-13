<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Word searcher</title>
</head>
<body>
<h2>Results</h2>
<#list searchResults as result>
    <div>
        <p>${result.url} - ${result.status} <#if result.errorMessage??>- ${result.errorMessage}</#if></p>
    </div>
</#list>
<form action="/">
    <input type="submit" value="Go back"/>
</form>
</body>
</html>