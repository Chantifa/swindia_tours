<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SwIndia Tours</title>
    <link rel="shortcut icon" href="resources/img/logo.png">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
</head>
<body>
<header>
    <hgroup>
        <h1 class="title">SwIndia Tours by Gihara</h1>
    </hgroup>
    <nav>
        <ul>
            <li> <a href="index.jsp">home</a> </li>
            <li><a href="register.jsp">register</a> </li>
            <li><a href="airportpickup_drop.html">Airport pickup & drop</a></li>
            <li><a href="delhi.html">Delhi</a></li>
            <li><a href="punjab.html">Punjab</a></li>
            <li><a href="rajasthan.html">Rajasthan</a></li>
            <li><a href="uttarpradesh.html">Uttarpradesh</a></li>
            <li><a href="mix.html">Mix Tours</a></li>
            <li><a href="uttrakhand.html">Uttarkhand</a></li>
            <li><a href="kashmir.html">Kashmir</a></li>
            <li><a href="himalayas.html">Himalayas</a></li>
            <li><a href="madhyapradesh.html">Madhyapradesh</a></li>
            <li><a href="goa.html">Goa</a></li>
            <li><a href="outsideIndia.html">Outside India</a></li>
            <li><a href="javascript:void(0);" class="icon" onclick="menuOnAndOff()">
                <i class="fa fa-bars"></i>
            </a></li>
        </ul>
    </nav>
</header>
<form action="register" method="post">
    <fieldset>
        <legend>register</legend>
        <table>
            <tbody>

            <tr>
                <th>
                    <label for="email">email:</label>
                </th>
            </tr>
            <tr>
                <td>
                    <input type="email"
                           name="email"
                           size="40"
                           maxlength="40"
                           title="muster@example.com"
                           placeholder="pls enter your email"
                           pattern=".{6,40}"
                           required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="password">password:</label>
                </th>
            </tr>
            <tr>
                <td>
                    <input type="password"
                           name="password"
                           size="10"
                           maxlength="10"
                           title="6-10 signals"
                           placeholder="pls enter your password"
                           pattern=".{6,10}"
                           required="required">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="submit">
                    <input type="reset">
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
<footer>
    <div id="opening-hours">
        <h3>Booking</h3>
        <p>24/24</p>
        <p>365/365</p>
        <p>we respond to your booking in 24 hours</p>

    </div>
    <div>
        <lo>
            <li><a href="about.html">About SwIndia Tours</a></li>
            <li><a href="feedback.html">Give us feedback & check customers feedback</a></li>
            <li><a href="contact.html">Contact us</a></li>
        </lo>
    </div>
    <div id="quote">
        <blockquote>
            An experience I will never forget, so lovely people and let you feel that you are a part of the country. I got the real taste of India.
            Definitely I will come back again. SwIndia Tours took care about everything, thank you so much.
        </blockquote>
        <cite>– Hanna (Sweden)</cite>
    </div>

    <div id="address">
        <h3>Address:</h3>
        <p>SwIndia Tours</p>
        <p>9818 Street No 8, Multani Dhanda, Pahar Ganj</p>
        <p>New Delhi, 110055, India</p>
        <p><a href="mailto:info@swindiatours.com">info@swindiatours.com</a></p>
        <p>+91 98 99293313</p>
    </div>
    <div>
        Copyright Ⓒ 2019 SwIndia Tours. All Right Reserved
    </div>
</footer>
</body>
</html><