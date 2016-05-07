<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Shopping Cart Application</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="login">Login <span class="sr-only">(current)</span></a></li>
		<li><a href="signup">Register<span class="sr-only">(current)</span></a></li>
		
		<li><a href="viewCart?userId=mark">View Cart <span id="cartCount"></span><span class="sr-only">(current)</span></a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
    function checkAvailability() {
        $.ajax({
            url : 'checkAvailability',
            success : function(data) {
                $('#responseDiv').html(data);
            }
        });
    }
    function autocomplete() {
        $.ajax({
            url : 'autocomplete',
            success : function(data) {
                $('#responseDiv').html(data);
            }
        });
    }
</script>
        <button type="submit" class="btn btn-default">Search Catalog</button>
      </form>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>