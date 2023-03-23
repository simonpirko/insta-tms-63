<jsp:include page="header.jsp"/>
<div class="container d-flex justify-content-center">

    <div style="max-width: 700px">
        <div class="card flex-grow-1 " style="border-radius: 15px; border: none">
            <div class="d-flex">
                <div class="flex-shrink-0"><img src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
                                                class="rounded-circle d-flex" style="width: 50px"
                                                alt="Avatar"/></div>
                <div class="flex-grow-1 ms-3">
                    <h5>Username</h5>
                    <p class="mb-2 pb-1">
                        Geolocation
                    </p>
                </div>

            </div>


            <img src="https://images.unsplash.com/photo-1477862096227-3a1bb3b08330?ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60"
                 alt="" class="card-img-top">
            <div class="card-body ">
                <h5 class="card-title"><a href="" class="btn btn-outline-danger btn-sm"><i class="far fa-heart"></i>
                    Like
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-heart" viewBox="0 0 16 16">
                        <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                    </svg>
                </a>
                </h5>

<%--                <div class="row">--%>
<%--                    <div class="col-md-12">--%>
<%--                        <div class="media">--%>
<%--                            <div class="media-body">--%>
<%--                                <div class="row">--%>
<%--                                    <div class="col-8 d-flex">--%>
<%--                                        <img class="mr-3 rounded-circle d-flex" style="max-width: 50px"--%>
<%--                                             alt="Bootstrap Media Preview" src="https://i.imgur.com/stD0Q19.jpg"/>--%>
<%--                                        <h5>Username</h5>--%>
<%--                                        <span>- 2 hours ago</span>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                Comment--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <a href="/comment">check all comments</a>
            </div>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>
