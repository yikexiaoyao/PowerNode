<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/11/12
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="main" style="width: 1000px;height:500px;"></div>
<div id="main1" style="width: 1000px;height:500px;"></div>
<script>
    function getmax(arr) {
        var max = arr[0];//假定第一个为最大值
        for (var i = 1; i < arr.length; i++) {//拿第一个和其余的数比较
            if (arr[i] > max) {//若有更大的
                max = arr[i];//将赋值给max
            }
        }
        return max;//返回最大值
    }

    $.get("${pageContext.request.contextPath}/workbench/chart/barEcharts", function (data) {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        var values = data.values;

        var number = getmax(values);

        for (var i = 0; i < values.length; i++) {//拿第一个和其余的数比较
            if (values[i] == number) {//若有更大的
                var obj = {
                    value: number,
                    itemStyle: {
                        color: 'green'
                    }
                };
                values[i] = obj;
            }
        }

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '交易统计图表'
            },
            tooltip: {},
            legend: {
                data: ['统计']
            },
            xAxis: {
                data: data.titles
            },
            yAxis: {},
            series: [
                {
                    name: '数量',
                    type: 'bar',
                    data: values
                }
            ]
        };
        console.log(option);
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }, 'json');

    $.get("${pageContext.request.contextPath}/workbench/chart/pieEcharts", function (data) {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main1'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '交易统计图表',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: '交易',
                    type: 'pie',
                    radius: '80%',
                    data: data,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }, 'json');

</script>
</body>
</html>
