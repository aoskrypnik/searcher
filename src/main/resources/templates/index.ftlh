<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Word searcher</title>
</head>
<body>
<h2>Enter parameters please for url search</h2>
<form action="/search" method="get">
    Start text:<br>
    <input type="text" name="text">
    <#if textError??>
        <div>
            <span style="color: red; ">${textError}</span>
        </div>
    </#if>
    <br><br>
    Search url:<br>
    <input type="text" name="url">
    <#if urlError??>
        <div>
            <span style="color: red; ">${urlError}</span>
        </div>
    </#if>
    <br><br>
    Thread number:<br>
    <input type="text" name="threadNum">
    <#if threadNumError??>
        <div>
            <span style="color: red; ">${threadNumError}</span>
        </div>
    </#if>
    <br><br>
    Max page number scanned:<br>
    <input type="text" name="pageNum">
    <#if pageNumError??>
        <div>
            <span style="color: red; ">${pageNumError}</span>
        </div>
    </#if>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>