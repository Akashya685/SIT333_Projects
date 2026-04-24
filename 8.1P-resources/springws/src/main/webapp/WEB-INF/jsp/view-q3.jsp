<html>
<body>

<h2>Q3</h2>

<p>${message}</p>

<p>What is 3 x 4?</p>

<form action="/q3" method="post">
	<input type="hidden" name="number1" value="3">
	<input type="hidden" name="number2" value="4">
	Your answer: <input type="text" name="result">
	<input type="submit" value="Submit">
</form>

</body>
</html>