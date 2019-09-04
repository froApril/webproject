<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${user}. </P>
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/6.5.0/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#config-web-app -->

<script>
    // Your web app's Firebase configuration
    var firebaseConfig = {
        apiKey: "AIzaSyDkXDuUm8jK9H-8v8qSsLThAZst1jUMqsI",
        authDomain: "webproject-9f90f.firebaseapp.com",
        databaseURL: "https://webproject-9f90f.firebaseio.com",
        projectId: "webproject-9f90f",
        storageBucket: "webproject-9f90f.appspot.com",
        messagingSenderId: "1023348280947",
        appId: "1:1023348280947:web:f05d2607bd3da5b6"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
</script>
</body>
</html>
