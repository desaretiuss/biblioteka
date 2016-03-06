<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<s:include value="Header.jsp"/>


<body style="overflow-y: hidden">

	<div class="container" style="margin-left: 300px; margin-top:-200px;">
		<h2>
			<p class="lead">Plotëso të dhënat e mëposhtme:</p>
		</h2>


		<form role="form" class="form-horizontal" method="post"
			action="addBook">

			<div class="form-group">
				<div class="col-sm-3">
					<label>Titulli</label><input class="form-control" name="book.title"
						placeholder="Titulli i librit" type="text">
				</div>
				<div class="col-sm-3">
					<label>Autori</label><input class="form-control" name="book.author"
						placeholder="Emri i autorit" type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3">
					<label>ISBN</label><input class="form-control" name="book.isbn"
						placeholder="ISBN" type="text">
				</div>
				<div class="col-sm-3">
					<label>Nr. Dewey</label><input class="form-control"
						name="book.deweyCode" placeholder="Kodi në Sistemin Dewey"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3">
					<label>Gjuha</label><input class="form-control"
						name="book.language" placeholder="Gjuha e këtij botimi"
						type="text">
				</div>
				<div class="col-sm-3">
					<label>Viti i publikimit</label><input class="form-control"
						name="book.year" placeholder="Viti i botimit" type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3">
					<label>Shtëpia Botuese</label><input class="form-control"
						name="book.publisher" placeholder="Shtëpia Botuese" type="text">
				</div>
				<div class="col-sm-3">
					<label>Nr. i botimit</label><input class="form-control"
						name="book.edition" placeholder="Nr. i botimit" type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3">
					<label>Nr. faqjeve</label><input class="form-control"
						name="book.pages" placeholder="Nr. faqjeve" type="text">
				</div>
				<div class="col-sm-3">
					<label>Nr. i kopjeve</label><input class="form-control"
						name="book.copies" placeholder="Nr. i kopjeve" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-12"></label>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-info pull-right">Dërgo</button>
				</div>
			</div>
		</form>
		<hr>
	</div>

</body>
</html>