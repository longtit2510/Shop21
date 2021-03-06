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
            QUẢN LÝ KHÁCH HÀNG
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
                                        <h4 class="card-title ">DANH SÁCH KHÁCH HÀNG</h4>
                                        <p class="card-category"> </p>
                                        <button  id="btnaddcus" type="button" rel="tooltip" onclick="openadd()" class="btn btn-primary btn-round">
                                            THÊM MỚI KHÁCH HÀNG 
                                        </button>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class=" text-primary">
                                                <th>
                                                    STT
                                                </th>
                                                <th>
                                                    Mã khách hàng
                                                </th>
                                                <th>
                                                    Họ tên
                                                </th>
                                                <th>
                                                    SĐT
                                                </th>
                                                <th>
                                                    Địa chỉ
                                                </th>
                                                <th>
                                                    Số CMND/CCCD
                                                </th>
                                                <th style="text-align: center">
                                                    Thao tác
                                                </th>
                                                </thead>
                                                <%!int i = 1;%>
                                                <%
                                                    List<Customer> employees = (List<Customer>) request.getAttribute("lstCustomer");

                                                    for (Customer e : employees) {
                                                %>
                                                <tbody>
                                                    <tr>
                                                        <td><%= i++%></td>
                                                        <td><%=e.getId()%></td>
                                                        <td><%=e.getName()%></td>
                                                        <td><%=e.getPhone()%></td>
                                                        <td><%=e.getAddress()%></td>
                                                        <td><%=e.getCertificate()%></td>
                                                        <td style="text-align: center">
                                                            <button id="btnsua" type="button" rel="tooltip" onclick="openedit('<%=e.getId()%>', '<%=e.getName()%>', '<%=e.getPhone()%>', '<%=e.getAddress()%>', '<%=e.getCertificate()%>')"  class="btn btn-primary btn-round">
                                                                SỬA
                                                            </button>
                                                            <button id ="btnxoa" type="button" rel="tooltip" onclick="confirmremove('<%=e.getId()%>')" class="btn btn-primary btn-round">
                                                                XÓA
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <%
                                                        }
                                                        i = 1;
                                                    %>
                                                </tbody>
                                            </table>
                                            <div class="modal fade" id="modeladd" role="dialog">
                                                <div class="modal-dialog" style="height: 450px;width: 40% ;border:black ;position: fixed;top: 50px;left: 30%;border-radius: 20px" >
                                                    <!-- Modal content-->
                                                    <div class="modal-content" style="background-color: #000000">
                                                        <form style="margin-top: 100px;padding: 40px 40px "action="AddCustomer" method="get">
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Họ và tên</label>
                                                                    <input id="name" name="name" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Số điện thoại</label>
                                                                    <input id="phone" name="phone" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Địa chỉ</label>
                                                                    <input id="address" name="address" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Số CMND/CCCD</label>
                                                                    <input id="certificate" name="certificate" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <button id="addbtn2" type="submit" rel="tooltip"  class="btn btn-primary btn-round">
                                                                Thêm Khách hàng
                                                            </button>
                                                            <button type="button"  rel="tooltip"  class="btn btn-primary btn-round" data-dismiss="modal">
                                                                Hủy
                                                            </button>
                                                        </form>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="modal fade" id="modeldelete" role="dialog">
                                                <div class="modal-dialog">

                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <form action="DeleteCustomer" method="get">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal">×</button>
                                                                <h4 class="modal-title">XÁC NHẬN XÓA?</h4>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <input id="iddelete" name="iddelete" type="text" class="form-control" hidden>
                                                                <button id="btnconfirmxoa" type="submit" class="btn btn-default" >Xác nhận</button>
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                                                            </div>
                                                        </form>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="modal fade" id="modeledit" role="dialog">
                                                <div class="modal-dialog" style="height: 450px;width: 40% ;border:black ;position: fixed;top: 50px;left: 30%;border-radius: 20px" >
                                                    <!-- Modal content-->
                                                    <div class="modal-content" style="background-color: #000000">
                                                        <form style="margin-top: 100px;padding: 40px 40px "action="EditCustomer" method="get">
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Họ và tên</label>
                                                                    <input id="idedit" name="idedit" type="text" class="form-control" hidden>
                                                                    <input id="nameedit" name="nameedit" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Số điện thoại</label>
                                                                    <input id="phoneedit" name="phoneedit" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Địa chỉ</label>
                                                                    <input id="addressedit" name="addressedit" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <div class="form-group bmd-form-group">
                                                                    <label class="bmd-label-floating">Số CMND/CCCD</label>
                                                                    <input id="certificateedit" name="certificateedit" type="text" class="form-control" required>
                                                                </div>
                                                            </div>
                                                            <button id="btnsua2" type="submit" rel="tooltip"  class="btn btn-primary btn-round">
                                                                Sửa Khách hàng
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
    function openadd() {
        $('#name').val("");
        $('#phone').val("");
        $('#address').val("");
        $('#certificate').val("");
        $("#modeladd").modal({backdrop: "static"});
    }
    ;
    function openedit(id, name, phone, address, certificate) {
        $('#idedit').val(id);
        $('#nameedit').val(name);
        $('#phoneedit').val(phone);
        $('#addressedit').val(address);
        $('#certificateedit').val(certificate);
        $("#modeledit").modal({backdrop: "static"});
    }
    ;
    function confirmremove(id) {
        $('#iddelete').val(id);
        $("#modeldelete").modal({backdrop: "static"});
    }
//    function closeadd() {
//
//        $('#modeladd').modal({backdrop: 'static', keyboard: false})
//    }
//    ;
</script>
