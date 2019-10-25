<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <title>MPK Store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 
</head>
<body>
  <nav id="navbar-darkblue" class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header"><a class="navbar-brand" href="/"><h5>MPK Stores</h5></a>
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
      </button>
    </div>
    
    <div class="collapse navbar-collapse navbar-menubuilder">
      <form class="navbar-form navbar-left" border="0" id="af" name="af" role="search" >
        <div class="input-group">
          <input type="text" class="form-control" id="aa" name="aa" placeholder="Search">
          <span class="input-group-btn">
            <button type="submit" class="btn btn-md" id="as" name="as" value="Go"><span class="glyphicon glyphicon-search"></span></button>
          </span>
        </div>
      </form>
      <ul class="nav navbar-nav navbar-right">

        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-th-list"></i> Services <b class="caret"></b></a>
          <ul class="dropdown-menu"> 
            <li><a href="/">Carwashes</a></li>
            <li><a href="/">Lapdances</a></li>
            <li><a href="/">Musicals</a></li>
            <li><a href="/">Tutorials</a></li>           
            <li><a href="/">Catering</a></li>
          </ul>
        </li>
               
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-tags"></i> Products <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="/">Books</a></li>
            <li><a href="/">Leaflets</a></li>
            <li><a href="/">CDs</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">Merchandise</li>
            <li><a href="/">Towels</a></li>
            <li><a href="/">Flags</a></li>
            <li><a href="/">Coffee Mugs</a></li>
          </ul>
        </li>
             
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> Profile <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="/"><i class="glyphicon glyphicon-user"></i> Profile</a></li>
            <li><a href="/"><i class="glyphicon glyphicon-plus"></i> Account</a></li>
            <li><a href="/"><i class="glyphicon glyphicon-cog"></i> Settings</a></li>
            <li><a href="/"><i class="glyphicon glyphicon-comment"></i> Notifications</a></li>           
          </ul>
        </li>        
      </ul>
    </div>
  </div>
  </nav><!-- /.navbar -->
</body>
</html>