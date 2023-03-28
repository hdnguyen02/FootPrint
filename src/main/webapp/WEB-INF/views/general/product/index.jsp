<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Foot Print</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value="/resources/css/product.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/global.css"/>"/>
    
    </head>
    <body style="overflow-x: hidden">
    
    	<jsp:include page="/WEB-INF/views/layout/nav-user.jsp" />
 		
        <div class="container" style="margin-top:120px">
            <div class="row">
                <jsp:include page="/WEB-INF/views/general/product/filter.jsp" />
            
                <!-- shop main wrapper start -->
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="shop-product-wrapper">
                        <!-- shop product top wrap start -->
                        <div class="shop-top-bar">
                            <div class="row align-items-center">
                                <div class="col-lg-7 col-md-6 order-2 order-md-1">
                                    <div class="top-bar-left">
                             
                                        <div class="product-amount">
                                            <p>Showing 1–16 of 21 results</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-5 col-md-6 order-1 order-md-2">
                                    <div class="top-bar-right">
                                        <div class="product-short">
                                            <p>Sort By : </p>
                                            <select class="nice-select" name="sortby" style="display: none;">
                                                <option value="trending">Relevance</option>
                                                <option value="sales">Name (A - Z)</option>
                                                <option value="sales">Name (Z - A)</option>
                                                <option value="rating">Price (Low &gt; High)</option>
                                                <option value="date">Rating (Lowest)</option>
                                                <option value="price-asc">Model (A - Z)</option>
                                                <option value="price-asc">Model (Z - A)</option>
                                            </select><div class="nice-select" tabindex="0"><span class="current">Relevance</span><ul class="list"><li data-value="trending" class="option selected">Relevance</li><li data-value="sales" class="option">Name (A - Z)</li><li data-value="sales" class="option">Name (Z - A)</li><li data-value="rating" class="option">Price (Low &gt; High)</li><li data-value="date" class="option">Rating (Lowest)</li><li data-value="price-asc" class="option">Model (A - Z)</li><li data-value="price-asc" class="option">Model (Z - A)</li></ul></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- shop product top wrap start -->

                        <!-- product item list wrapper start -->
                        <div class="shop-product-wrap grid-view row mbn-30">
                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <div class="product-thumb">
                                        <a href="https://htmldemo.net/pullman/pullman/product-details.html">
                                            <img src="https://ananas.vn/wp-content/uploads/Pro_AV00155_2-500x500.jpg" alt="product thumb">
                                        </a>
                                        <div class="button-group">
                                            <a href="https://htmldemo.net/pullman/pullman/wishlist.html" data-bs-toggle="tooltip" title="" data-bs-original-title="Add to Wishlist" aria-label="Add to Wishlist"><i class="fa fa-heart-o"></i></a>
                                            <a href="https://htmldemo.net/pullman/pullman/shop.html#" data-bs-toggle="modal" data-bs-target="#quick_view"><span data-bs-toggle="tooltip" title="" data-bs-original-title="Quick View" aria-label="Quick View"><i class="fa fa-eye"></i></span></a>
                                        </div>
                                        <div class="product-label">
                                            <span>new</span>
                                        </div>
                              
                                    </div>
                                    <div class="product-content">
                                        <div class="product-caption">
                                            <h6 class="product-name">
                                                <a href="https://htmldemo.net/pullman/pullman/product-details.html">Quickiin Mens shoes</a>
                                            </h6>
                                            <div class="price-box">
                                                <span class="price-old"><del>$90.00</del></span>
                                                <span class="price-regular">$70.00</span>
                                            </div>
                                            <a class="add-to-cart" href="https://htmldemo.net/pullman/pullman/cart.html"><i class="fa fa-shopping-cart"></i></a>
                                        </div>
                                        <div class="ratings">
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <div class="product-thumb">
                                        <a href="https://htmldemo.net/pullman/pullman/product-details.html">
                                            <img src="./assets/img/product/product-1.jpg" alt="product thumb">
                                        </a>
                                        <div class="button-group">
                                            <a href="https://htmldemo.net/pullman/pullman/wishlist.html" data-bs-toggle="tooltip" title="" data-bs-original-title="Add to Wishlist" aria-label="Add to Wishlist"><i class="fa fa-heart-o"></i></a>
                                            <a href="https://htmldemo.net/pullman/pullman/shop.html#" data-bs-toggle="modal" data-bs-target="#quick_view"><span data-bs-toggle="tooltip" title="" data-bs-original-title="Quick View" aria-label="Quick View"><i class="fa fa-eye"></i></span></a>
                                        </div>
                                        <div class="product-label">
                                            <span>new</span>
                                        </div>
                                
                                    </div>
                                    <div class="product-content-list">
                                        <h4 class="product-name"><a href="https://htmldemo.net/pullman/pullman/product-details.html">Quickiin Mens shoes</a></h4>
                                        <div class="ratings">
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                        </div>
                                        <div class="price-box">
                                            <span class="price-old"><del>$29.99</del></span>
                                            <span class="price-regular">$50.00</span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam.
                                        </p>
                                        <a href="https://htmldemo.net/pullman/pullman/cart.html" class="btn btn-large hover-color">Add To Cart</a>
                                    </div>
                                </div>
                                
                                
                                <!-- product list item end -->
                            </div>
                            
                            
                            
                            
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <div class="product-thumb">
                                        <a href="https://htmldemo.net/pullman/pullman/product-details.html">
                                            <img src='https://ananas.vn/wp-content/uploads/Pro_AV00154_1.jpg' alt="product thumb">
                                        </a>
                                        <div class="button-group">
                                            <a href="https://htmldemo.net/pullman/pullman/wishlist.html" data-bs-toggle="tooltip" title="" data-bs-original-title="Add to Wishlist" aria-label="Add to Wishlist"><i class="fa fa-heart-o"></i></a>
                                            <a href="https://htmldemo.net/pullman/pullman/shop.html#" data-bs-toggle="modal" data-bs-target="#quick_view"><span data-bs-toggle="tooltip" title="" data-bs-original-title="Quick View" aria-label="Quick View"><i class="fa fa-eye"></i></span></a>
                                        </div>
                                        <div class="product-label">
                                            <span>new</span>
                                        </div>
                                    </div>
                                    <div class="product-content">
                                        <div class="product-caption">
                                            <h6 class="product-name">
                                                <a href="https://htmldemo.net/pullman/pullman/product-details.html">Womens High Hills</a>
                                            </h6>
                                            <div class="price-box">
                                                <span class="price-old"><del>$85.00</del></span>
                                                <span class="price-regular">$60.00</span>
                                            </div>
                                            <a class="add-to-cart" href="https://htmldemo.net/pullman/pullman/cart.html"><i class="fa fa-shopping-cart"></i></a>
                                        </div>
                                        <div class="ratings">
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <div class="product-thumb">
                                        <a href="https://htmldemo.net/pullman/pullman/product-details.html">
                                            <img src="./assets/img/product/product-2.jpg" alt="product thumb">
                                        </a>
                                        <div class="button-group">
                                            <a href="https://htmldemo.net/pullman/pullman/wishlist.html" data-bs-toggle="tooltip" title="" data-bs-original-title="Add to Wishlist" aria-label="Add to Wishlist"><i class="fa fa-heart-o"></i></a>
                                            <a href="https://htmldemo.net/pullman/pullman/shop.html#" data-bs-toggle="modal" data-bs-target="#quick_view"><span data-bs-toggle="tooltip" title="" data-bs-original-title="Quick View" aria-label="Quick View"><i class="fa fa-eye"></i></span></a>
                                        </div>
                                        <div class="product-label">
                                            <span>new</span>
                                        </div>
                                    </div>
                                    <div class="product-content-list">
                                        <h4 class="product-name"><a href="https://htmldemo.net/pullman/pullman/product-details.html">Womens High Hills</a></h4>
                                        <div class="ratings">
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                        </div>
                                        <div class="price-box">
                                            <span class="price-old"><del>$85.00</del></span>
                                            <span class="price-regular">$70.00</span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam.
                                        </p>
                                        <a href="https://htmldemo.net/pullman/pullman/cart.html" class="btn btn-large hover-color">Add To Cart</a>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            
                            
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <div class="product-thumb">
                                        <a href="https://htmldemo.net/pullman/pullman/product-details.html">
                                            <img src='https://ananas.vn/wp-content/uploads/Pro_AV00174_2-500x500.jpeg' alt="product thumb">
                                        </a>
                                        <div class="button-group">
                                            <a href="https://htmldemo.net/pullman/pullman/wishlist.html" data-bs-toggle="tooltip" title="" data-bs-original-title="Add to Wishlist" aria-label="Add to Wishlist"><i class="fa fa-heart-o"></i></a>
                                            <a href="https://htmldemo.net/pullman/pullman/shop.html#" data-bs-toggle="modal" data-bs-target="#quick_view"><span data-bs-toggle="tooltip" title="" data-bs-original-title="Quick View" aria-label="Quick View"><i class="fa fa-eye"></i></span></a>
                                        </div>
                                        <div class="product-label">
                                            <span>new</span>
                                        </div>
                                    </div>
                                    <div class="product-content">
                                        <div class="product-caption">
                                            <h6 class="product-name">
                                                <a href="https://htmldemo.net/pullman/pullman/product-details.html">Womens High Hills</a>
                                            </h6>
                                            <div class="price-box">
                                                <span class="price-old"><del>$85.00</del></span>
                                                <span class="price-regular">$60.00</span>
                                            </div>
                                            <a class="add-to-cart" href="https://htmldemo.net/pullman/pullman/cart.html"><i class="fa fa-shopping-cart"></i></a>
                                        </div>
                                        <div class="ratings">
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <div class="product-thumb">
                                        <a href="https://htmldemo.net/pullman/pullman/product-details.html">
                                            <img src="./assets/img/product/product-2.jpg" alt="product thumb">
                                        </a>
                                        <div class="button-group">
                                            <a href="https://htmldemo.net/pullman/pullman/wishlist.html" data-bs-toggle="tooltip" title="" data-bs-original-title="Add to Wishlist" aria-label="Add to Wishlist"><i class="fa fa-heart-o"></i></a>
                                            <a href="https://htmldemo.net/pullman/pullman/shop.html#" data-bs-toggle="modal" data-bs-target="#quick_view"><span data-bs-toggle="tooltip" title="" data-bs-original-title="Quick View" aria-label="Quick View"><i class="fa fa-eye"></i></span></a>
                                        </div>
                                        <div class="product-label">
                                            <span>new</span>
                                        </div>
                                    </div>
                                    <div class="product-content-list">
                                        <h4 class="product-name"><a href="https://htmldemo.net/pullman/pullman/product-details.html">Womens High Hills</a></h4>
                                        <div class="ratings">
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                            <span><i class="fa fa-star"></i></span>
                                        </div>
                                        <div class="price-box">
                                            <span class="price-old"><del>$85.00</del></span>
                                            <span class="price-regular">$70.00</span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam.
                                        </p>
                                        <a href="https://htmldemo.net/pullman/pullman/cart.html" class="btn btn-large hover-color">Add To Cart</a>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                         
                          

                           

      
                           

                           

                        <!-- start pagination area -->
                        <div class="paginatoin-area text-center">
                            <ul class="pagination-box">
                                <li><a class="previous" href="https://htmldemo.net/pullman/pullman/shop.html#"><i class="fa fa-angle-left"></i></a></li>
                                <li class="active"><a href="https://htmldemo.net/pullman/pullman/shop.html#">1</a></li>
                                <li><a href="https://htmldemo.net/pullman/pullman/shop.html#">2</a></li>
                                <li><a href="https://htmldemo.net/pullman/pullman/shop.html#">3</a></li>
                                <li><a class="next" href="https://htmldemo.net/pullman/pullman/shop.html#"><i class="fa fa-angle-right"></i></a></li>
                            </ul>
                        </div>
                        <!-- end pagination area -->
                    </div>
                </div>
                <!-- shop main wrapper end -->
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/layout/footer-user.jsp" />
    </body>
</html>

