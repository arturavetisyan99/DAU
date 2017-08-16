<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<s:head/>
<sx:head/>
<head>
    <title>Analytics</title>
    <style>
        table.list {
            border-collapse: collapse;
            width: 10%;
        }

        table.list, table.list td, table.list th {
            border: 1px solid gray;
            padding: 5px;
        }
        .form-container{
            padding: 100px;
        }
        .form-container form,
        .form-container form  {
            display: inline-block;
            border-style: solid;
            vertical-align: top;
            padding: 30px;
        }
        .retention{
            width: 330px;
        }
       #errorDate {
           font-weight: bold;
           color: red;
       }
    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
    <script>
        var i = 0;
        function addDates() {
            var opValue = document.getElementsByName("dateOfUser")[0].value.substring(0, 10);
            var error = document.getElementsByName("errorDate")
            if (opValue == "") {
                $('#errorDate').show();
                return;
            }
            $('#errorDate').hide();
            var table = $('.list')
            var tr = $('<tr></tr>')
            var td = $('<td></td>')
            td.append('<input type="text" name="dates[' + i + ']" value="' + opValue + '"/>');
            tr.append(td);
            table.append(tr);
            i++;
        }

    </script>
</head>
<body>
<h2>Analytics</h2>
<div class="form-container">
    <s:form method="post" action="dau">
        <div id="errorDate" style="display: none;">You should select a Date.</div>
        <table>
            <tr>
                <td><sx:datetimepicker name="dateOfUser" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
                <td><input value="Add Date" type="button" onclick="addDates();return false;"/></td>
            </tr>
        </table>
        <table class="list">
            <tr>
                <th align="left">Date</th>
            </tr>

        </table>
        <div>
            <s:submit align="left" key="label.dau"/>
        </div>

    </s:form>

    <s:form method="post" action="retention">

        <table class="retention">
            <tr>
                <td>
                    <sx:datetimepicker name="retentionDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/>

                </td>
            </tr>
            <tr>
                <td>
                    <s:select label="Select a Retention Type"
                              headerKey="-1" headerValue="Select Retetion"
                              list="#{'1':'Day1', '7':'Day7', '40':'Day40'}"
                              name="type"
                    />

                </td>
            </tr>
            <tr>
                <td>
                    <s:submit align="left" key="label.retention"/>
                </td>
            </tr>
        </table>
    </s:form>
</div>
</body>
</html>