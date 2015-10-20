<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="Neon Admin Panel" />
<meta name="author" content="" />

<title>Taller Proyectos</title>
<jsp:include page="/resources/include/header-resources.jsp"></jsp:include>

</head>
<body class="page-body">

	<div class="page-container">
		<jsp:include page="/resources/include/sidebar-menu.jsp"></jsp:include>
		
		<div class="main-content">
			<jsp:include page="/resources/include/profile-bar.jsp"></jsp:include>		

			<hr />

			<div class="mail-env">

				<!-- compose new email button -->
				<div class="mail-sidebar-row visible-xs">
					<a href="mailbox-compose.html"
						class="btn btn-success btn-icon btn-block"> Compose Mail <i
						class="entypo-pencil"></i>
					</a>
				</div>


				<!-- Mail Body -->
				<div class="mail-body">

					<div class="mail-header">
						<!-- title -->
						<div class="mail-title">
							Reset your Apple ID password <span class="label label-warning">Friends</span>
							<span class="label label-info">Sport</span>
						</div>

						<!-- links -->
						<div class="mail-links">

							<a href="#" class="btn btn-default"> <i class="entypo-print"></i>
							</a> <a href="#" class="btn btn-default"> <i class="entypo-trash"></i>
							</a> <a class="btn btn-primary btn-icon"> Reply <i
								class="entypo-reply"></i>
							</a>

						</div>
					</div>

					<div class="mail-info">

						<div class="mail-sender dropdown">

							<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img
								src="<%=request.getServletContext().getContextPath() %>/resources/assets/images/thumb-1.png" class="img-circle" width="30" />
								<span>Arlind Nushi</span> (noreply@example.com) to <span>me</span>
							</a>

							<ul class="dropdown-menu dropdown-red">

								<li><a href="#"> <i class="entypo-user"></i> Add to
										Contacts
								</a></li>
								<li><a href="#"> <i class="entypo-menu"></i> Show other
										messages
								</a></li>
								<li class="divider"></li>
								<li><a href="#"> <i class="entypo-star"></i> Star this
										message
								</a></li>
								<li><a href="#"> <i class="entypo-reply"></i> Reply
								</a></li>
								<li><a href="#"> <i class="entypo-right"></i> Forward
								</a></li>
							</ul>

						</div>

						<div class="mail-date">07:51 AM - 15 December</div>

					</div>

					<div class="mail-text">

						<p>Lose away off why half led have near bed. At engage simple
							father of period others except. My giving do summer of though
							narrow marked at. Spring formal no county ye waited. My whether
							cheered at regular it of promise blushes perhaps. Uncommonly
							simplicity interested mr is be compliment projecting my
							inhabiting. Gentleman he september in oh excellent.</p>

						<p>New the her nor case that lady paid read. Invitation
							friendship travelling eat everything the out two. Shy you who
							scarcely expenses debating hastened resolved. Always polite
							moment on is warmth spirit it to hearts. Downs those still witty
							an balls so chief so. Moment an little remain no up lively no.
							Way brought may off our regular country towards adapted cheered.</p>

						<p>Use securing confined his shutters. Delightful as he it
							acceptance an solicitude discretion reasonably. Carriage we
							husbands advanced an perceive greatest. Totally dearest expense
							on demesne ye he. Curiosity excellent commanded in me. Unpleasing
							impression themselves to at assistance acceptance my or. On
							consider laughter civility offended oh.</p>

						<p>Oh he decisively impression attachment friendship so if
							everything. Whose her enjoy chief new young. Felicity if ye
							required likewise so doubtful. On so attention necessary at by
							provision otherwise existence direction. Unpleasing up announcing
							unpleasant themselves oh do on. Way advantage age led listening
							belonging supposing.</p>

						<p>So by colonel hearted ferrars. Draw from upon here gone add
							one. He in sportsman household otherwise it perceived instantly.
							Is inquiry no he several excited am. Called though excuse length
							ye needed it he having. Whatever throwing we on resolved entrance
							together graceful. Mrs assured add private married removed
							believe did she.</p>

					</div>

					

					<div class="mail-reply">

						<div class="fake-form">
							<div>
								<a href="mailbox-compose.html">Reply</a> or <a
									href="mailbox-compose.html">Forward</a> this message...
							</div>
						</div>

					</div>

				</div>

				<!-- Sidebar -->
				<div class="mail-sidebar">

					<!-- compose new email button -->
					<div class="mail-sidebar-row hidden-xs">
						<a href="mailbox-compose.html"
							class="btn btn-success btn-icon btn-block"> Compose Mail <i
							class="entypo-pencil"></i>
						</a>
					</div>

					<!-- menu -->
					<ul class="mail-menu">
						<li class="active"><a href="#"> <span
								class="badge badge-danger pull-right">6</span> Inbox
						</a></li>

						<li><a href="#"> <span
								class="badge badge-gray pull-right">1</span> Sent
						</a></li>

						<li><a href="#"> Drafts </a></li>

						<li><a href="#"> <span
								class="badge badge-gray pull-right">1</span> Spam
						</a></li>

						<li><a href="#"> Trash </a></li>
					</ul>

					<div class="mail-distancer"></div>
				

				</div>

			</div>

			<hr />
			<!-- Footer -->
			<footer class="main">

				&copy; 2014 <strong>Neon</strong> Admin Theme by <a
					href="http://laborator.co" target="_blank">Laborator</a>

			</footer>
		</div>


		<div id="chat" class="fixed" data-current-user="Art Ramadani"
			data-order-by-status="1" data-max-chat-history="25">

			<div class="chat-inner">


				<h2 class="chat-header">
					<a href="#" class="chat-close"><i class="entypo-cancel"></i></a> <i
						class="entypo-users"></i> Chat <span
						class="badge badge-success is-hidden">0</span>
				</h2>


				<div class="chat-group" id="group-1">
					<strong>Favorites</strong> <a href="#" id="sample-user-123"
						data-conversation-history="#sample_history"><span
						class="user-status is-online"></span> <em>Catherine J.
							Watkins</em></a> <a href="#"><span class="user-status is-online"></span>
						<em>Nicholas R. Walker</em></a> <a href="#"><span
						class="user-status is-busy"></span> <em>Susan J. Best</em></a> <a
						href="#"><span class="user-status is-offline"></span> <em>Brandon
							S. Young</em></a> <a href="#"><span class="user-status is-idle"></span>
						<em>Fernando G. Olson</em></a>
				</div>


				<div class="chat-group" id="group-2">
					<strong>Work</strong> <a href="#"><span
						class="user-status is-offline"></span> <em>Robert J. Garcia</em></a> <a
						href="#" data-conversation-history="#sample_history_2"><span
						class="user-status is-offline"></span> <em>Daniel A. Pena</em></a> <a
						href="#"><span class="user-status is-busy"></span> <em>Rodrigo
							E. Lozano</em></a>
				</div>


				<div class="chat-group" id="group-3">
					<strong>Social</strong> <a href="#"><span
						class="user-status is-busy"></span> <em>Velma G. Pearson</em></a> <a
						href="#"><span class="user-status is-offline"></span> <em>Margaret
							R. Dedmon</em></a> <a href="#"><span class="user-status is-online"></span>
						<em>Kathleen M. Canales</em></a> <a href="#"><span
						class="user-status is-offline"></span> <em>Tracy J. Rodriguez</em></a>
				</div>

			</div>

			<!-- conversation template -->
			<div class="chat-conversation">

				<div class="conversation-header">
					<a href="#" class="conversation-close"><i class="entypo-cancel"></i></a>

					<span class="user-status"></span> <span class="display-name"></span>
					<small></small>
				</div>

				<ul class="conversation-body">
				</ul>

				<div class="chat-textarea">
					<textarea class="form-control autogrow"
						placeholder="Type your message"></textarea>
				</div>

			</div>

		</div>


		<!-- Chat Histories -->
		<ul class="chat-history" id="sample_history">
			<li><span class="user">Art Ramadani</span>
				<p>Are you here?</p> <span class="time">09:00</span></li>

			<li class="opponent"><span class="user">Catherine J.
					Watkins</span>
				<p>This message is pre-queued.</p> <span class="time">09:25</span></li>

			<li class="opponent"><span class="user">Catherine J.
					Watkins</span>
				<p>Whohoo!</p> <span class="time">09:26</span></li>

			<li class="opponent unread"><span class="user">Catherine
					J. Watkins</span>
				<p>Do you like it?</p> <span class="time">09:27</span></li>
		</ul>




		<!-- Chat Histories -->
		<ul class="chat-history" id="sample_history_2">
			<li class="opponent unread"><span class="user">Daniel A.
					Pena</span>
				<p>I am going out.</p> <span class="time">08:21</span></li>

			<li class="opponent unread"><span class="user">Daniel A.
					Pena</span>
				<p>Call me when you see this message.</p> <span class="time">08:27</span>
			</li>
		</ul>


	</div>




	<!-- Bottom scripts (common) -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/gsap/main-gsap.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/bootstrap.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/joinable.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/resizeable.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-api.js"></script>


	<!-- Imported scripts on this page -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-mail.js"></script>
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-chat.js"></script>


	<!-- JavaScripts initializations and stuff -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-custom.js"></script>


	<!-- Demo Settings -->
	<script src="<%=request.getServletContext().getContextPath() %>/resources/assets/js/neon-demo.js"></script>

</body>
</html>