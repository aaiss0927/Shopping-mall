<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title> DUNE </title>
    <style>
        html, body { margin: 0; padding: 0; height: 100%; }
        header { width: 100%; height: 2.7%; border-bottom: 2px solid plum; }
        nav { width: 100%; height: 8%; border-bottom: 1px solid lightgray; box-shadow: 2px 1px 7px 1px lightgray;}
        section {
            width: 100%;
            height: 70%;
            position: relative;
            border-bottom: 1px solid black;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header ul {
            margin : 0;
            padding : 0;
            width : 100%;
            text-align: right;
        }
        header ul li {
            display : inline-block;
            list-style-type : none;
            padding : 2px 0px;
            margin-left: 3px;
            margin-right: 2px;

        }
        header ul li a {
            color:black;
            font-size: 12px;
            text-decoration : none;
        }
        header ul li a:hover {
            color : gray;
        }


        nav ul {
            margin: 0;
            padding: 0;
            width: 100%;
            position: relative;
        }
        nav ul li {
            display: inline-block;
            list-style-type: none;
            padding: 0px 10px;
            margin-top: 18px;
            margin-left: 7px;
            position: relative;
        }
        nav ul li a {
            color:black;
            text-decoration : none;
        }
        nav ul li a:hover {
            color : gray;
        }

        footer ul li {
            list-style-type : none;
        }

        #footer_1 {
            width: 100%;
            height: 40%;
            position: relative;
            display: flex;
            justify-content: space-between;
        }
        #footer_1 > div {
            margin-top: 4%;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }
        #footer_2 {
            width: 100%;
            height: 3.8%;
            position: relative;
        }

        .textbox-container {
            display: flex;
            align-items: center;
            margin: 10px;
        }
        .textbox {
            flex: 1;
            min-width: 250px;
            border: 1px solid black;
            padding: 10px;
            margin-right: 10px;
        }
        .submit-button {
            display: inline-block;
            background: powderblue;
            width: 60px;
            height: 15px;
            padding: 15px;
            text-align: center;
            border-radius: 22px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody tr:hover {
            background-color: #f5f5f5;
            cursor: pointer;
        }
        input[type="button"] {
            border: 1px solid rgba(0, 0, 0, 0.3);
            padding: 6px;
            cursor: pointer;
        }
    </style>
    <script>
        function init() {
            let subArray = document.getElementsByClassName("subscribe");
            for (let i = 0; i < subArray.length; i++) {
                let sub = subArray[i];
                sub.onmouseover = function() {
                    sub.style.backgroundColor = "tomato";
                };
                sub.onmouseout = function() {
                    sub.style.backgroundColor = "sandybrown";
                };
                sub.onclick = function() {
                    location.href = "subscribe.jsp";
                };
            }

            let submitArray = document.getElementsByClassName("submit-button");
            for (let i = 0; i < submitArray.length; i++) {
                let submit = submitArray[i];
                submit.onmouseover = function() {
                    submit.style.backgroundColor = "skyblue";
                };
                submit.onmouseout = function() {
                    submit.style.backgroundColor = "powderblue";
                };
            }
        }

        function submitText() {
            var textBox = document.getElementById("textbox");
            var text = textBox.innerText.trim();
            textBox.innerText = '';
            alert(text + '로 메일을 발송했습니다.');
        }
    </script>
</head>
<body onload="init()">
<header>
    <%
        String loginId = (String) session.getAttribute("loginId");
    %>
    <ul>
        <% if (loginId != null) { %>
        <li><a href=""><strong style="color:blueviolet; font-size:12px; text-decoration : none;">&nbsp;&nbsp;<%= loginId %></strong></a></li>
        <li><a href="/member/logout">&nbsp;&nbsp;로그아웃</a></li>
        <% } else { %>
        <li><a href="/member/login">&nbsp;&nbsp;로그인</a></li>
        <li><a href="/member/signup">&nbsp;&nbsp;회원가입</a></li>
        <% } %>

        <li><a href="/member/mypage">&nbsp;&nbsp;My페이지</a></li>
        <li><a href="/cart">&nbsp;&nbsp;장바구니</a></li>
        <li><a>&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
    </ul>
</header>
<nav>
    <ul>
        <li style="margin-left: 25px;"><a href="/project/main" style="font-size:25px"><strong style="color:cornflowerblue">DUNE</strong></a></li>
        <li style="margin-left: 90px;"><a href="/product/product_all_1">ALL</a></li>
        <li><a href="/product/product_csv">CSV</a></li>
        <li><a href="/product/product_mod">MOD</a></li>
        <li><a href="/product/product_liquid">액상</a></li>
        <li><a href="/product/subscribe">구독</a></li>
        <script>
            for (let i = 0; i < 180; i++) {
                document.write("&nbsp;");
            }
        </script>
        <li><a href="/project/notice">공지사항</a></li>
        <li><a href="/project/faq">FAQ</a></li>
        <li><a href="/board/paging">문의하기</a></li>
        <li><a href="/project/center">고객센터</a></li>
    </ul>
</nav><br><br>
<section>
    <div style="width:60%; margin:auto;">
        <strong style="font-size:25px">장바구니</strong><hr style="background:skyblue; height:2.5px; border:0;"><br>
        <table>
            <thead>
            <tr>
                <th>상품번호</th><th>상품명</th><th>개수</th><th>상품 가격</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cartList}" var="cart">
                <tr>
                    <td>${cart.productSku}</td>
                    <td>${cart.productName}</td>
                    <td>${cart.quantity}</td>
                    <td>${cart.productPrice}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table><br>
        <div></div>
    </div>
</section>

<footer id="footer_1" style="font-size:15px">
    <div style="width:30%; height:80%; margin-left:80px;">
        <strong style="font-size:20px">&nbsp;[DUNE 뉴스레터]</strong>
        <p>&nbsp;&nbsp;지금 구독하시고 매달 뉴스레터, 구독 플랜 특가 혜택, 리미티드<br>&nbsp;&nbsp;에디션 액상 소식을 가장 먼저 받아보세요.</p>
        <p>&nbsp;&nbsp;이메일을 입력하세요.</p>
        <div class="textbox-container">
            <p class="textbox" id="textbox" contenteditable="true"></p>
            <p class="submit-button" onclick="submitText()"><strong>제출</strong></p>
        </div>
    </div>
    <div style="width:15%; height:80%;"></div>
    <div style="width:15%; height:80%;"></div>
    <div style="width:15%; height:80%;">
        <p style="line-height: 2em;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong style="font-size:20px">쇼핑몰</strong><br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="" style="text-decoration: none;">구독 서비스</a><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="" style="text-decoration: none;">배송 및 환불</a><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="" style="text-decoration: none;">매장 정책</a><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="" style="text-decoration: none;">결제 방법</a>
        </p>
    </div>
    <div style="width:15%; height:80%;">
        <p style="line-height: 1.5em;">
            <strong style="font-size:20px; line-height: 1.5em;">문의</strong><br><br><br>
            인천광역시 미추홀구<br>
            인하로 100<br>
            inha@edu.co.kr<br>
            Tel: 032-123-4567
        </p>
    </div>
</footer>
<footer id="footer_2" style="font-size:12px">
    <a href="" style="margin-left: 90px;"><img src="../resources/media/insta.jpg" height="20px" width="20px"></a>
    <a href="" style="margin-left: 20px;"><img src="../resources/media/facebook.jpg" height="20px" width="20px"></a>
    <a href="" style="margin-left: 20px;"><img src="../resources/media/kakao.jpg" height="20px" width="20px"></a>
    <script>
        for (let i = 0; i < 350; i++) { document.write("&nbsp"); }
    </script>
    &copy; DUNE Corp.
</footer>
</body>
</html>
