<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Thêm hình ảnh cho
		sách</h1>
	<a href="<c:url value="/quan-tri/tao-moi-sach"></c:url>"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
		<i class="fas fa-download fa-sm text-white-50"></i> Tạo mới
	</a>
</div>

<div class="row">
	<div class="col-lg-12 mb-4">
		<c:if test="${ state != null }">
			<div class="card bg-secondary text-white shadow">
				<div class="card-body">
					${ state }
					<div>
						<a class="text-white-50 small"
							href="<c:url value="/quan-tri/pdf-cua-sach/${ book.ID }"></c:url>">Tắt
							thông báo này</a>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Thêm PDF cho sách
			"${ book.name }"</h6>
	</div>
	<div class="card-body">
		<c:url var="post_url" value="/quan-tri/them-pdf-cua-sach"></c:url>
		<form:form method="POST" action="${ post_url }"
			modelAttribute="pdfUpload" enctype="multipart/form-data">
			<div class="form-horizontal">

				<form:hidden path="bookId" />
				<div class="form-group">
					<label class="control-label" for="commonsMultipartFile">Chọn
						PDF</label>
					<div>
						<input type="file" id="commonsMultipartFile"
							name="commonsMultipartFile" class="form-control">
						<form:errors path="commonsMultipartFile"
							cssClass="field-validation-valid text-danger" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<input type="submit" value="Thêm PDF" class="btn btn-success">
					</div>
				</div>
			</div>
		</form:form>

		<h6 class="m-0 font-weight-bold text-primary">PDF hiện tại của
			sách</h6>

		<div class="table-responsive">
			<div id="dataTable" class="dataTables_wrapper dt-bootstrap4">
				<table class="table table-bordered table table-hover">
					<tbody>
						<tr>
							<th style="width: 25%;">Pdf</th>
							<td><c:if test="${ book.pdf == null }">PDF hiện tại không sẵn có</c:if>
								<c:if test="${ book.pdf != null }">
									<div>
										<button id="prev">Previous</button>
										<button id="next">Next</button>
										&nbsp; &nbsp; <span>Page: <span id="page_num"></span> /
											<span id="page_count"></span></span>
									</div>
									<canvas id="pdf"></canvas>
								</c:if>
						</tr>
						<tr>
							<th style="width: 25%;">Xóa hình ảnh</th>
							<td><c:url var="post_url" value="/quan-tri/xoa-pdf-cua-sach"></c:url>
								<form:form id="deleteBookImage" method="POST"
									action="${ post_url }">
									<input type="hidden" name="id" value="${ book.ID }" />
									<button type="submit" class="btn btn-danger">Xóa</button>
								</form:form></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<div class="card-footer">
		<a class="btn btn-primary"
			href="<c:url value="/quan-tri/danh-sach-sach"></c:url>">Quay về
			danh sách</a> <a class="btn btn-primary"
			href="<c:url value="/quan-tri/chi-tiet-sach/${ book.ID }"></c:url>">Xem
			chi tiết</a> <a class="btn btn-success"
			href="<c:url value="/quan-tri/chinh-sua-sach/${ book.ID }"></c:url>">Chỉnh
			sửa</a> <a class="btn btn-success"
			href="<c:url value="/quan-tri/hinh-anh-cua-sach/${ book.ID }"></c:url>">Hình
			ảnh</a> <a class="btn btn-success"
			href="<c:url value="/quan-tri/tac-gia-cua-sach/${ book.ID }"></c:url>">Tác
			giả</a>
	</div>
</div>

<c:if test="${ book.pdf != null }">
	<style type="text/css">
#pdf {
	border: 1px solid black;
	direction: ltr;
	width: 150px;
	height: 250px;
}
</style>

	<script type="text/javascript">
		//If absolute URL from the remote server is provided, configure the CORS
		//header on that server.
		var url = "<c:url value="/file-upload/pdfs/${ book.pdf }"></c:url>";

		//Loaded via <script> tag, create shortcut to access PDF.js exports.
		var pdfjsLib = window["pdfjs-dist/build/pdf"];

		//The workerSrc property shall be specified.
		pdfjsLib.GlobalWorkerOptions.workerSrc = "<c:url value="/assets/pdfjs/build/pdf.worker.js"></c:url>";

		var pdfDoc = null, pageNum = 1, pageRendering = false, pageNumPending = null, scale = 0.8, canvas = document
				.getElementById("pdf"), ctx = canvas.getContext("2d");

		/**
		 * Get page info from document, resize canvas accordingly, and render page.
		 * @param num Page number.
		 */
		function renderPage(num) {
			pageRendering = true;
			// Using promise to fetch the page
			pdfDoc.getPage(num).then(function(page) {
				var viewport = page.getViewport({
					scale : scale
				});
				canvas.height = viewport.height;
				canvas.width = viewport.width;

				// Render PDF page into canvas context
				var renderContext = {
					canvasContext : ctx,
					viewport : viewport
				};
				var renderTask = page.render(renderContext);

				// Wait for rendering to finish
				renderTask.promise.then(function() {
					pageRendering = false;
					if (pageNumPending !== null) {
						// New page rendering is pending
						renderPage(pageNumPending);
						pageNumPending = null;
					}
				});
			});

			// Update page counters
			document.getElementById("page_num").textContent = num;
		}

		/**
		 * If another page rendering in progress, waits until the rendering is
		 * finised. Otherwise, executes rendering immediately.
		 */
		function queueRenderPage(num) {
			if (pageRendering) {
				pageNumPending = num;
			} else {
				renderPage(num);
			}
		}

		/**
		 * Displays previous page.
		 */
		function onPrevPage() {
			if (pageNum <= 1) {
				return;
			}
			pageNum--;
			queueRenderPage(pageNum);
		}
		document.getElementById("prev").addEventListener("click", onPrevPage);

		/**
		 * Displays next page.
		 */
		function onNextPage() {
			if (pageNum >= pdfDoc.numPages) {
				return;
			}
			pageNum++;
			queueRenderPage(pageNum);
		}
		document.getElementById("next").addEventListener("click", onNextPage);

		/**
		 * Asynchronously downloads PDF.
		 */
		pdfjsLib.getDocument(url).promise
				.then(function(pdfDoc_) {
					pdfDoc = pdfDoc_;
					document.getElementById("page_count").textContent = pdfDoc.numPages;

					// Initial/first page rendering
					renderPage(pageNum);
				});
	</script>
</c:if>