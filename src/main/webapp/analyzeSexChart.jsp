<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>数据分析</title>
    <link rel="shortcut icon" href="${webRoot}/images/malaria.ico"/>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${webRoot}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css?v=4.1.0" rel="stylesheet">
    <style>
        .floatBox {
            width: 12%;
            height: auto;
            border-radius: 5px;
            box-shadow: 2px 2px 3px #2a2e36;
            position: fixed;
            float: right;
            top: 20%;
            right: 30px;
            z-index: 900;
        }
    </style>
</head>
<body>
<!--数据来源部分-->
<div id="fixDiv" class="floatBox">
    <div class="panel panel-default">
        <div class="panel-body">
            <div>
                <h4 style="font-weight: 300">&nbsp;&nbsp;数据来源（地区）:</h4>
                <select id="dataSource" class="form-control">
                    <option value="default" selected>默认</option>
                </select>
            </div>
            <%--<div>--%>
            <%--<h4 style="font-weight: 300">&nbsp;&nbsp;数据开始年份:</h4>--%>
            <%--<select id="beginYear" class="form-control">--%>
            <%--<option selected>未选</option>--%>
            <%--<option>2005</option>--%>
            <%--</select>--%>
            <%--<h4 style="font-weight: 300">&nbsp;&nbsp;数据结束年份:</h4>--%>
            <%--<select id="endYear" class="form-control">--%>
            <%--<option selected>未选</option>--%>
            <%--<option>2005</option>--%>
            <%--</select>--%>
            <%--</div>--%>
        </div>
        <div class="panel-footer">
            <div align="center">
                <button id="searchBtn" class="btn-primary btn-lg">查询</button>
            </div>
        </div>
    </div>

</div>
<!--标签页部分-->
<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-9">
            <div class="tabs-container">
                <ul class="nav nav-tabs" role="tablist" id="myTab">
                    <li id="d1" class="col-sm-6 active">
                        <a data-toggle="tab" href="#tab-1" aria-expanded="true">
                            <h2 align="center"><strong>恶性疟</strong></h2>
                        </a>
                    </li>
                    <li id="d2" class="col-sm-6">
                        <a data-toggle="tab" href="#tab-2" aria-expanded="false">
                            <h2 align="center"><strong>间日疟</strong></h2>
                        </a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div id="tab-1" class="tab-pane fade in active" role="tabpanel">
                        <div class="panel-body">
                            <div class="col-sm-12">
                                <div id="sexChartTab_1" style="height:300px"></div>
                            </div>
                            <div class="col-sm-12">
                                <div id="ageChartTab_1" style="height:300px"></div>
                            </div>
                            <div class="col-sm-12">
                                <div id="careerChartTab_1" style="height:400px"></div>
                            </div>
                        </div>
                    </div>
                    <div id="tab-2" class="tab-pane fade active" role="tabpanel">
                        <div class="panel-body">
                            <div class="col-sm-12">
                                <div id="sexChartTab_2" style="height:300px"></div>
                            </div>
                            <div class="col-sm-12">
                                <div id="ageChartTab_2" style="height:300px"></div>
                            </div>
                            <div class="col-sm-12">
                                <div id="careerChartTab_2" style="height:400px"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
<script src="${webRoot}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${webRoot}/js/build/dist/echarts.js"></script>
<!--地址联动js-->
<script>
    $(function () {
        $.ajax({
            type: "get",
            url: "/district/getProvinces.do",
            dataType: "json",
            success: function (data) {
                $.each(data.data, function (i, item) {
                    var $option = '<option code=' + item.id + ' value=' + item.name + '>' + item.name + '</option>';
                    $("#dataSource").append($option);
                });
            },
            error: function (data) {
                console.error("出错了，返回的data：" + data);
            }
        });
    });
</script>
<script type="text/javascript">
    // 路径配置
    require.config({
        paths: {
            echarts: '${webRoot}/js/build/dist'
        }
    });
    require(
            [
                'echarts',
                'echarts/chart/pie', // 饼图加载
                'echarts/chart/funnel'//漏斗图加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var sexChartTab_1 = ec.init(document.getElementById('sexChartTab_1'));
                var sexChartTab_2 = ec.init(document.getElementById('sexChartTab_2'));
                var ageChartTab_1 = ec.init(document.getElementById('ageChartTab_1'));
                var ageChartTab_2 = ec.init(document.getElementById('ageChartTab_2'));
                var careerChartTab_1 = ec.init(document.getElementById('careerChartTab_1'));
                var careerChartTab_2 = ec.init(document.getElementById('careerChartTab_2'));
                var initOption = initChartOption();

                sexChartTab_1.setOption(initOption);
                sexChartTab_2.setOption(initOption);
                ageChartTab_1.setOption(initOption);
                ageChartTab_2.setOption(initOption);
                careerChartTab_1.setOption(initOption);
                careerChartTab_2.setOption(initOption);
                //初始化时加载
                $(function () {
                    var dataSource = $('#dataSource').val();
                    sexAjaxFunction(dataSource, sexChartTab_1, sexChartTab_2);
                    ageAjaxFunction(dataSource, ageChartTab_1, ageChartTab_2);
                    careerAjaxFunction(dataSource, careerChartTab_1, careerChartTab_2);
                });
                $('#searchBtn').on('click', function () {
                    sexChartTab_1.setOption(initOption);
                    sexChartTab_2.setOption(initOption);
                    ageChartTab_1.setOption(initOption);
                    ageChartTab_2.setOption(initOption);
                    careerChartTab_1.setOption(initOption);
                    careerChartTab_2.setOption(initOption);
                    var dataSource = $('#dataSource').val();
                    console.info(dataSource);
                    sexAjaxFunction(dataSource, sexChartTab_1, sexChartTab_2);
//                    ageAjaxFunction(dataSource, ageChartTab_1, ageChartTab_2);
                    $.ajax({
                        type: "post",
                        url: "/AnalyzeByCharts/ageGroupChart",
                        data: {
                            dataSource: dataSource
                        },
                        dataType: "json",
                        success: function (data) {
                            for (var dataIndex = 0; dataIndex < data.length; dataIndex++) {
                                //for timeLine
                                var yearList = data[dataIndex].yearList;
                                var yearListLength = yearList.length;
                                if (data[dataIndex].disease === "恶性疟") {
                                    var ageChartOption = initChartOption();
                                    ageChartTab_1.setOption(ageChartOption);
                                    ageChartOption.options[0].series[0].data = [];
                                    ageChartOption.options[0].title.text = '年龄组比例分析';
                                    ageChartOption.options[0].title.subtext = '恶性疟患者';
                                    for (var yearIndex = 0; yearIndex < yearListLength; yearIndex++) {
                                        if (0 === yearIndex) {
                                            ageChartOption.options[0].legend.data = [];
                                            ageChartOption.options[0].legend.data = data[dataIndex].ageGroupList[0];
                                            ageChartOption.options[0].series[0].name = yearList[yearIndex] + '';
                                            for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[0].length; ageIndex++) {
                                                ageChartOption.options[0].series[0].data.push({
                                                    value: data[dataIndex].valuesList[0][ageIndex],
                                                    name: data[dataIndex].ageGroupList[0][ageIndex]
                                                });
                                            }
                                            console.log("ageChartOption.options[0]: "+ageChartOption);
                                        } else {
                                            var item = seriesItem();
                                            item.legend.data = [];
                                            item.legend.data = data[dataIndex].ageGroupList[yearIndex];
                                            item.series[0].name = yearList[yearIndex];
                                            item.series[0].data = [];
                                            for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[yearIndex].length; ageIndex++) {
                                                item.series[0].data.push({
                                                    value: data[dataIndex].valuesList[yearIndex][ageIndex],
                                                    name: data[dataIndex].ageGroupList[yearIndex][ageIndex]
                                                });
                                            }
                                            ageChartOption.options.push(item);
                                        }
                                    }
                                    console.log(" ageChartTab_1.setOption(ageChartOption);"+ageChartOption);
                                    ageChartOption.timeline.data = yearList;
                                    ageChartTab_1.setOption(ageChartOption);
                                }
                                if (data[dataIndex].disease === "间日疟") {
                                    var ageChartOption = initChartOption();
                                    ageChartTab_2.setOption(ageChartOption);
                                    ageChartOption.options[0].series[0].data = [];
                                    ageChartOption.options[0].title.text = '年龄组比例分析';
                                    ageChartOption.options[0].title.subtext = '间日疟患者';
                                    for (var yearIndex = 0; yearIndex < yearListLength; yearIndex++) {
                                        if (0 === yearIndex) {
                                            ageChartOption.options[0].legend.data = [];
                                            ageChartOption.options[0].legend.data = data[dataIndex].ageGroupList[0];
                                            ageChartOption.options[0].series[0].name = yearList[yearIndex] + '';
                                            for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[0].length; ageIndex++) {
                                                ageChartOption.options[0].series[0].data.push({
                                                    value: data[dataIndex].valuesList[0][ageIndex],
                                                    name: data[dataIndex].ageGroupList[0][ageIndex]
                                                });
                                            }
                                        } else {
                                            var item = seriesItem();
                                            item.legend.data = [];
                                            item.legend.data = data[dataIndex].ageGroupList[yearIndex];
                                            item.series[0].name = yearList[yearIndex];
                                            item.series[0].data = [];
                                            for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[yearIndex].length; ageIndex++) {
                                                item.series[0].data.push({
                                                    value: data[dataIndex].valuesList[yearIndex][ageIndex],
                                                    name: data[dataIndex].ageGroupList[yearIndex][ageIndex]
                                                });
                                            }
                                            ageChartOption.options.push(item);
                                        }
                                    }
                                    ageChartOption.timeline.data = yearList;
                                    ageChartTab_2.setOption(ageChartOption);
                                }
                            }
                        },
                        error: function (data) {
                            console.error("Error Happend" + data);
                        }
                    });
                    careerAjaxFunction(dataSource, careerChartTab_1, careerChartTab_2);
                });
            }
    );
    function sexSeriesItem() {
        return {
            series: [{
                //动态赋值
                name: 'NoData',
                type: 'pie',
                center: ['50%', '45%'],
                radius: '50%',
                //动态赋值
                data: []
            }]
        }
    }
    function seriesItem() {
        return {
            legend: {
                data: ['NoData']
            },
            series: [{
                //动态赋值
                name: 'NoData',
                type: 'pie',
                center: ['50%', '45%'],
                radius: '50%',
                //动态赋值
                data: []
            }]
        }
    }
    function initChartOption() {
        return {
            timeline: {
                //动态数据
                data: ['暂无数据'],
                playInterval: 800,
                label: {
                    formatter: function (s) {
                        return s.slice(0, 7);
                    }
                }
            },
            noDataLoadingOption: {
                text: '暂无数据',
                effect: 'bubble'
            },
            options: [{
                //动态数据
                title: {
                    text: '暂无数据',
                    subtext: '暂无数据'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    show: false,
                    //动态数据
                    data: ['NoData', 'NoData']
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {
                            show: true,
//                            type: ['pie', 'funnel'],
                            type: ['pie'],
//                            option: {
//                                funnel: {
//                                    x: '25%',
//                                    width: '50%',
//                                    funnelAlign: 'left',
//                                    //动态数据
//                                    max: 0
//                                }
//                            }
                        },
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                series: [
                    {
                        //动态数据
                        name: '暂无数据',
                        type: 'pie',
                        center: ['50%', '45%'],
                        radius: '50%',
                        //动态数据
                        data: [{value: 0, name: '暂无数据'}, {value: 0, name: '暂无数据'}]
                    }
                ]
            }]
        }
    }
    function sexAjaxFunction(dataSource, sexChartTab_1, sexChartTab_2) {
        $.ajax({
            type: "post",
            url: "/AnalyzeByCharts/sexChart",
            data: {
                dataSource: dataSource
            },
            dataType: "json",
            success: function (data) {
                var sexCategory = data[0].sexList;
                for (var index = 0; index < data.length; index++) {
                    //用于设置sexChart的Option属性
                    var yearList = data[index].yearList;
                    var yearListLength = yearList.length;
                    if (data[index].disease == "恶性疟") {
                        var sexChartOption = initChartOption();
                        sexChartOption.options[0].series[0].data = [];
                        sexChartOption.options[0].title.text = '性别比例分析';
                        sexChartOption.options[0].title.subtext = '恶性疟患者';
                        for (var i = 0; i < yearListLength; i++) {
                            if (0 === i) {
                                sexChartOption.options[i].legend.data = sexCategory;
                                sexChartOption.options[i].series[i].name = yearList[i] + '';
                                sexChartOption.options[i].series[i].data.push({
                                    value: data[index].valuesList[i * sexCategory.length],
                                    name: sexCategory[0] + ''
                                });
                                sexChartOption.options[i].series[i].data.push({
                                    value: data[index].valuesList[i * sexCategory.length + 1],
                                    name: sexCategory[1] + ''
                                });
                            } else {
                                var item = sexSeriesItem();
                                item.series[0].name = yearList[i];
                                item.series[0].data.push({
                                    value: data[index].valuesList[i * sexCategory.length],
                                    name: sexCategory[0] + ''
                                });
                                item.series[0].data.push({
                                    value: data[index].valuesList[i * sexCategory.length + 1],
                                    name: sexCategory[1] + ''
                                });
                                sexChartOption.options.push(item);
                            }
                        }
                        sexChartOption.timeline.data = yearList;
//                        console.log(sexChartOption);
                        sexChartTab_1.setOption(sexChartOption);
//                        $(window).resize(sexChartTab_1);
                    }
                    if (data[index].disease == "间日疟") {
                        var sexChartOption = initChartOption();
                        sexChartOption.options[0].series[0].data = [];
                        sexChartOption.options[0].title.text = '性别比例分析';
                        sexChartOption.options[0].title.subtext = '间日疟患者';
                        for (var i = 0; i < yearListLength; i++) {
                            if (0 === i) {
                                sexChartOption.options[i].legend.data = sexCategory;
                                sexChartOption.options[i].series[i].name = yearList[i] + '';
                                sexChartOption.options[i].series[i].data.push({
                                    value: data[index].valuesList[i * sexCategory.length],
                                    name: sexCategory[0] + ''
                                });
                                sexChartOption.options[i].series[i].data.push({
                                    value: data[index].valuesList[i * sexCategory.length + 1],
                                    name: sexCategory[1] + ''
                                });
                            } else {
                                var item = sexSeriesItem();
                                item.series[0].name = yearList[i];
                                item.series[0].data.push({
                                    value: data[index].valuesList[i * sexCategory.length],
                                    name: sexCategory[0] + ''
                                });
                                item.series[0].data.push({
                                    value: data[index].valuesList[i * sexCategory.length + 1],
                                    name: sexCategory[1] + ''
                                });
                                sexChartOption.options.push(item);
                            }
                        }
                        sexChartOption.timeline.data = yearList;
//                        console.log(sexChartOption);
                        sexChartTab_2.setOption(sexChartOption);
                    }
                }
            },
            error: function (data) {
                console.error(data);
            }
        });
    }
    function ageAjaxFunction(dataSource, ageChartTab_1, ageChartTab_2) {
        $.ajax({
            type: "post",
            url: "/AnalyzeByCharts/ageGroupChart",
            data: {
                dataSource: dataSource
            },
            dataType: "json",
            success: function (data) {
                for (var dataIndex = 0; dataIndex < data.length; dataIndex++) {
                    //for timeLine 
                    var yearList = data[dataIndex].yearList;
                    var yearListLength = yearList.length;
                    if (data[dataIndex].disease === "恶性疟") {
                        var ageChartOption = initChartOption();
                        ageChartTab_1.setOption(ageChartOption);
                        ageChartOption.options[0].series[0].data = [];
                        ageChartOption.options[0].title.text = '年龄组比例分析';
                        ageChartOption.options[0].title.subtext = '恶性疟患者';
                        for (var yearIndex = 0; yearIndex < yearListLength; yearIndex++) {
                            if (0 === yearIndex) {
                                ageChartOption.options[0].legend.data = [];
                                ageChartOption.options[0].legend.data = data[dataIndex].ageGroupList[0];
                                ageChartOption.options[0].series[0].name = yearList[yearIndex] + '';
                                for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[0].length; ageIndex++) {
                                    ageChartOption.options[0].series[0].data.push({
                                        value: data[dataIndex].valuesList[0][ageIndex],
                                        name: data[dataIndex].ageGroupList[0][ageIndex]
                                    });
                                }
                                console.log("ageChartOption.options[0]: "+ageChartOption);
                            } else {
                                var item = seriesItem();
                                item.legend.data = [];
                                item.legend.data = data[dataIndex].ageGroupList[yearIndex];
                                item.series[0].name = yearList[yearIndex];
                                item.series[0].data = [];
                                for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[yearIndex].length; ageIndex++) {
                                    item.series[0].data.push({
                                        value: data[dataIndex].valuesList[yearIndex][ageIndex],
                                        name: data[dataIndex].ageGroupList[yearIndex][ageIndex]
                                    });
                                }
                                ageChartOption.options.push(item);
                            }
                        }
                        console.log(" ageChartTab_1.setOption(ageChartOption);"+ageChartOption);
                        ageChartOption.timeline.data = yearList;
                        ageChartTab_1.setOption(ageChartOption);
                    }
                    if (data[dataIndex].disease === "间日疟") {
                        var ageChartOption = initChartOption();
                        ageChartTab_2.setOption(ageChartOption);
                        ageChartOption.options[0].series[0].data = [];
                        ageChartOption.options[0].title.text = '年龄组比例分析';
                        ageChartOption.options[0].title.subtext = '间日疟患者';
                        for (var yearIndex = 0; yearIndex < yearListLength; yearIndex++) {
                            if (0 === yearIndex) {
                                ageChartOption.options[0].legend.data = [];
                                ageChartOption.options[0].legend.data = data[dataIndex].ageGroupList[0];
                                ageChartOption.options[0].series[0].name = yearList[yearIndex] + '';
                                for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[0].length; ageIndex++) {
                                    ageChartOption.options[0].series[0].data.push({
                                        value: data[dataIndex].valuesList[0][ageIndex],
                                        name: data[dataIndex].ageGroupList[0][ageIndex]
                                    });
                                }
                            } else {
                                var item = seriesItem();
                                item.legend.data = [];
                                item.legend.data = data[dataIndex].ageGroupList[yearIndex];
                                item.series[0].name = yearList[yearIndex];
                                item.series[0].data = [];
                                for (var ageIndex = 0; ageIndex < data[dataIndex].ageGroupList[yearIndex].length; ageIndex++) {
                                    item.series[0].data.push({
                                        value: data[dataIndex].valuesList[yearIndex][ageIndex],
                                        name: data[dataIndex].ageGroupList[yearIndex][ageIndex]
                                    });
                                }
                                ageChartOption.options.push(item);
                            }
                        }
                        ageChartOption.timeline.data = yearList;
                        ageChartTab_2.setOption(ageChartOption);
                    }
                }
            },
            error: function (data) {
                console.error("Error Happend" + data);
            }
        });
    }
    function careerAjaxFunction(dataSource, careerChartTab_1, careerChartTab_2) {
        $.ajax({
            type: "post",
            url: "/AnalyzeByCharts/careerChart",
            data: {
                dataSource: dataSource
            },
            dataType: "json",
            success: function (data) {
                for (var dataIndex = 0; dataIndex < data.length; dataIndex++) {
                    //for timeLine
                    var yearList = data[dataIndex].yearList;
                    var yearListLength = yearList.length;
                    if (data[dataIndex].disease === "恶性疟") {
                        var careerChartOption = initChartOption();
                        careerChartOption.options[0].series[0].data = [];
                        careerChartOption.options[0].title.text = '职业比例分析';
                        careerChartOption.options[0].title.subtext = '恶性疟患者';
                        for (var yearIndex = 0; yearIndex < yearListLength; yearIndex++) {
                            if (0 === yearIndex) {
                                careerChartOption.options[0].legend.data = [];
                                careerChartOption.options[0].legend.data = data[dataIndex].careerList[0];
                                careerChartOption.options[0].series[0].name = yearList[yearIndex] + '';
                                for (var ageIndex = 0; ageIndex < data[dataIndex].careerList[0].length; ageIndex++) {
                                    careerChartOption.options[0].series[0].data.push({
                                        value: data[dataIndex].valuesList[0][ageIndex],
                                        name: data[dataIndex].careerList[0][ageIndex]
                                    });
                                }
                            } else {
                                var item = seriesItem();
                                item.legend.data = [];
                                item.legend.data = data[dataIndex].careerList[yearIndex];
                                item.series[0].name = yearList[yearIndex];
                                item.series[0].data = [];
                                for (var ageIndex = 0; ageIndex < data[dataIndex].careerList[yearIndex].length; ageIndex++) {
                                    item.series[0].data.push({
                                        value: data[dataIndex].valuesList[yearIndex][ageIndex],
                                        name: data[dataIndex].careerList[yearIndex][ageIndex]
                                    });
                                }
                                careerChartOption.options.push(item);
                            }
                        }
                        careerChartOption.timeline.data = yearList;
                        careerChartTab_1.setOption(careerChartOption);
                    }
                    if (data[dataIndex].disease === "间日疟") {
                        var careerChartOption = initChartOption();
                        careerChartOption.options[0].series[0].data = [];
                        careerChartOption.options[0].title.text = '职业比例分析';
                        careerChartOption.options[0].title.subtext = '间日疟患者';
                        for (var yearIndex = 0; yearIndex < yearListLength; yearIndex++) {
                            if (0 === yearIndex) {
                                careerChartOption.options[0].legend.data = [];
                                careerChartOption.options[0].legend.data = data[dataIndex].careerList[0];
                                careerChartOption.options[0].series[0].name = yearList[yearIndex] + '';
                                for (var ageIndex = 0; ageIndex < data[dataIndex].careerList[0].length; ageIndex++) {
                                    careerChartOption.options[0].series[0].data.push({
                                        value: data[dataIndex].valuesList[0][ageIndex],
                                        name: data[dataIndex].careerList[0][ageIndex]
                                    });
                                }
                            } else {
                                var item = seriesItem();
                                item.legend.data = [];
                                item.legend.data = data[dataIndex].careerList[yearIndex];
                                item.series[0].name = yearList[yearIndex];
                                item.series[0].data = [];
                                for (var ageIndex = 0; ageIndex < data[dataIndex].careerList[yearIndex].length; ageIndex++) {
                                    item.series[0].data.push({
                                        value: data[dataIndex].valuesList[yearIndex][ageIndex],
                                        name: data[dataIndex].careerList[yearIndex][ageIndex]
                                    });
                                }
                                careerChartOption.options.push(item);
                            }
                        }
                        careerChartOption.timeline.data = yearList;
                        careerChartTab_2.setOption(careerChartOption);
                    }
                }
            },
            error: function (data) {
                console.error("Error Happend" + data);
            }
        });
    }
</script>
</body>
</html>