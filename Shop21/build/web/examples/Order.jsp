<%@page import="Model.Order"%>
<%@page import="Model.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="/assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="/assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            QUẢN LÝ ĐƠN BÁN HÀNG
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
        <link href="assets/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="assets/demo/demo.css" rel="stylesheet" />
    </head>

    <body class="dark-edition">
        <div class="wrapper ">
            <div class="sidebar" data-color="purple" data-background-color="black" data-image="assets/img/sidebar-2.jpg">
                <!--
                  Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"
          
                  Tip 2: you can also add an image using data-image tag
                -->
                <div class="logo"><a href="https://www.facebook.com/longtit2510" class="simple-text logo-normal">
                        CỬA HÀNG NHÓM 21 
                    </a></div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="nav-item  ">
                            <a class="nav-link" href="/Shop21/Customer">
                                <p>QUẢN LÝ KHÁCH HÀNG</p>
                            </a>
                        </li>
                        <li class="nav-item  ">
                            <a class="nav-link" href="/Shop21/Order">
                                <p>QUẢN LÝ ĐƠN BÁN HÀNG</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top " id="navigation-example">
                    <div class="container-fluid">
                    </div>
                </nav>
                <!-- End Navbar -->
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header card-header-primary">
                                        <h4 class="card-title ">DANH SÁCH ĐƠN BÁN HÀNG</h4>
                                        <p class="card-category"> </p>

                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class=" text-primary">
                                                <th>
                                                    STT
                                                </th>
                                                <th>
                                                    Mã đơn
                                                </th>
                                                <th>
                                                    Mã khách hàng
                                                </th>
                                                <th>
                                                    Tổng giá
                                                </th>
                                                <th>
                                                    Ngày tạo đơn hàng
                                                </th>
                                                <th>
                                                    Trạng thái
                                                </th>
                                                <th style="text-align: center">
                                                    Thao tác
                                                </th>
                                                </thead>
                                                <%!int i = 1;%>
                                                <%
                                                    List<Order> employees = (List<Order>) request.getAttribute("lstOrder");

                                                    for (Order e : employees) {
                                                %>
                                                <tbody>
                                                    <tr>
                                                        <td><%= i++%></td>
                                                        <td><%=e.getId()%></td>
                                                        <td><%=e.getId_customer()%></td>
                                                        <td><%=e.getTotalprice()%></td>
                                                        <td><%=e.getStartDate()%></td>
                                                        <td><%=e.getStatus()%></td>
                                                        <td style="text-align: center">
                                                            <button id ="btnxemct"type="button" rel="tooltip" class="btn btn-primary btn-round">
                                                                <a href="Detail?did=<%=e.getId()%>">
                                                                    XEM CHI TIẾT
                                                                </a>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <%
                                                        }
                                                        i = 1;
                                                    %>
                                                </tbody>
                                            </table>
                                            <div class="modal fade" id="modeledit" role="dialog">
                                                <div class="modal-dialog" style="height: 450px;width: 40% ;border:black ;position: fixed;top: 50px;left: 30%;border-radius: 20px" >
                                                    <!-- Modal content-->
                                                    <div class="modal-content" style="background-color: #000000">
                                                        <form style="margin-top: 100px;padding: 40px 40px "action="EditOrder" method="get">
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Mã khách hàng</label>
                                                                    <input id="idorder" name="idorder" type="text" class="form-control" hidden>
                                                                    <input id="id_customer" name="id_customer" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Tổng giá</label>
                                                                    <input id="totalprice" name="totalprice" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Ngày khởi tạo</label>
                                                                    <input id="startDate" name="startDate" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Trạng thái đơn hàng</label>
                                                                    <input id="status" name="status" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <button type="submit" rel="tooltip"  class="btn btn-primary btn-round">
                                                                Sửa đơn hàng
                                                            </button>
                                                            <button type="button"  rel="tooltip"  class="btn btn-primary btn-round" data-dismiss="modal">
                                                                Hủy
                                                            </button>
                                                        </form>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="container-fluid">

                        <div class="copyright float-right" id="date">
                            ,Made<i class="material-icons"></i> by
                            <a href="https://www.facebook.com/longtit2510" target="_blank">Snowyy</a> for SQA.
                        </div>
                    </div>
                </footer>
                <script>
                    const x = new Date().getFullYear();
                    let date = document.getElementById('date');
                    date.innerHTML = '&copy; ' + x + date.innerHTML;
                </script>
            </div>
        </div>

        <!--   Core JS Files   -->
        <script src="assets/js/core/jquery.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <script src="assets/js/core/bootstrap-material-design.min.js"></script>
        <script src="https://unpkg.com/default-passive-events"></script>
        <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!-- Place this tag in your head or just before your close body tag. -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <script src="assets/js/plugins/chartist.min.js"></script>
        <script src="assets/js/plugins/bootstrap-notify.js"></script>
        <script src="assets/js/material-dashboard.js?v=2.1.0"></script>
        <script src="assets/demo/demo.js"></script>
        <script>
                    $(document).ready(function () {
                        $().ready(function () {
                            $sidebar = $('.sidebar');

                            $sidebar_img_container = $sidebar.find('.sidebar-background');

                            $full_page = $('.full-page');

                            $sidebar_responsive = $('body > .navbar-collapse');

                            window_width = $(window).width();

                            $('.fixed-plugin a').click(function (event) {
                                // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
                                if ($(this).hasClass('switch-trigger')) {
                                    if (event.stopPropagation) {
                                        event.stopPropagation();
                                    } else if (window.event) {
                                        window.event.cancelBubble = true;
                                    }
                                }
                            });

                            $('.fixed-plugin .active-color span').click(function () {
                                $full_page_background = $('.full-page-background');

                                $(this).siblings().removeClass('active');
                                $(this).addClass('active');

                                var new_color = $(this).data('color');

                                if ($sidebar.length != 0) {
                                    $sidebar.attr('data-color', new_color);
                                }

                                if ($full_page.length != 0) {
                                    $full_page.attr('filter-color', new_color);
                                }

                                if ($sidebar_responsive.length != 0) {
                                    $sidebar_responsive.attr('data-color', new_color);
                                }
                            });

                            $('.fixed-plugin .background-color .badge').click(function () {
                                $(this).siblings().removeClass('active');
                                $(this).addClass('active');

                                var new_color = $(this).data('background-color');

                                if ($sidebar.length != 0) {
                                    $sidebar.attr('data-background-color', new_color);
                                }
                            });

                            $('.fixed-plugin .img-holder').click(function () {
                                $full_page_background = $('.full-page-background');

                                $(this).parent('li').siblings().removeClass('active');
                                $(this).parent('li').addClass('active');


                                var new_image = $(this).find("img").attr('src');

                                if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                                    $sidebar_img_container.fadeOut('fast', function () {
                                        $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                                        $sidebar_img_container.fadeIn('fast');
                                    });
                                }

                                if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                                    var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                                    $full_page_background.fadeOut('fast', function () {
                                        $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                                        $full_page_background.fadeIn('fast');
                                    });
                                }

                                if ($('.switch-sidebar-image input:checked').length == 0) {
                                    var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
                                    var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                                    $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                                    $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                                }

                                if ($sidebar_responsive.length != 0) {
                                    $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
                                }
                            });

                            $('.switch-sidebar-image input').change(function () {
                                $full_page_background = $('.full-page-background');

                                $input = $(this);

                                if ($input.is(':checked')) {
                                    if ($sidebar_img_container.length != 0) {
                                        $sidebar_img_container.fadeIn('fast');
                                        $sidebar.attr('data-image', '#');
                                    }

                                    if ($full_page_background.length != 0) {
                                        $full_page_background.fadeIn('fast');
                                        $full_page.attr('data-image', '#');
                                    }

                                    background_image = true;
                                } else {
                                    if ($sidebar_img_container.length != 0) {
                                        $sidebar.removeAttr('data-image');
                                        $sidebar_img_container.fadeOut('fast');
                                    }

                                    if ($full_page_background.length != 0) {
                                        $full_page.removeAttr('data-image', '#');
                                        $full_page_background.fadeOut('fast');
                                    }

                                    background_image = false;
                                }
                            });

                            $('.switch-sidebar-mini input').change(function () {
                                $body = $('body');

                                $input = $(this);

                                if (md.misc.sidebar_mini_active == true) {
                                    $('body').removeClass('sidebar-mini');
                                    md.misc.sidebar_mini_active = false;

                                    $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

                                } else {

                                    $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

                                    setTimeout(function () {
                                        $('body').addClass('sidebar-mini');

                                        md.misc.sidebar_mini_active = true;
                                    }, 300);
                                }

                                // we simulate the window Resize so the charts will get updated in realtime.
                                var simulateWindowResize = setInterval(function () {
                                    window.dispatchEvent(new Event('resize'));
                                }, 180);

                                // we stop the simulation of Window Resize after the animations are completed
                                setTimeout(function () {
                                    clearInterval(simulateWindowResize);
                                }, 1000);

                            });
                        });
                    });
        </script>
    </body>

</html>
<script>
//    function openadd() {
//        $('#name').val("");
//        $('#phone').val("");
//        $('#address').val("");
//        $('#certificate').val("");
//        $("#modeladd").modal({backdrop: "static"});
//    }
//    ;
    function openedit(idorder, id_customer, totalprice, startDate, status) {
        $('#idorder').val(idorder);
        $('#id_customer').val(id_customer);
        $('#totalprice').val(totalprice);
        $('#startDate').val(startDate);
        $('#status').val(status);
        $("#modeledit").modal({backdrop: "static"});
    }
    ;
//    function confirmremove(id) {
//        $('#iddelete').val(id);
//        $("#modeldelete").modal({backdrop: "static"});
//    }
//    function closeadd() {
//
//        $('#modeladd').modal({backdrop: 'static', keyboard: false})
//    }
//    ;
</script>
