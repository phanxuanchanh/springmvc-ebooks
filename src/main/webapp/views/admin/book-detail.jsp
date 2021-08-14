<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Chi tiết sách</h1>
	<a href="<c:url value="/quan-tri/tao-moi-sach"></c:url>"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
		<i class="fas fa-download fa-sm text-white-50"></i> Tạo mới
	</a>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Chi tiết sách "${ bookInfo.name }"</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable" class="dataTables_wrapper dt-bootstrap4">
				<table class="table table-bordered table table-hover">
					<tbody>
						<tr>
							<th style="width: 25%;">ID sách</th>
							<td>${ bookInfo.ID }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Tên sách</th>
							<td>${ bookInfo.name }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Mô tả sách</th>
							<td>${ bookInfo.description }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Thể loại</th>
							<td><c:if test="${ bookInfo.category != null }">
								${ bookInfo.category.name }
								</c:if></td>
						</tr>
						<tr>
							<th style="width: 25%;">Nhà xuất bản</th>
							<td><c:if test="${ bookInfo.publishingHouse != null }">
								${ bookInfo.publishingHouse.name }
								</c:if></td>
						</tr>
						<tr>
							<th style="width: 25%;">Tác giả</th>
							<td>
								<ul>
									<c:forEach var="item" items="${ bookInfo.bookAuthorInfos }">
										<li>${ item.name }--Vai trò: ${ item.roleName }</li>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<tr>
							<th style="width: 25%;">Lượt xem</th>
							<td>${ bookInfo.views }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Lượt thích</th>
							<td>${ bookInfo.upvote }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Lượt không thích</th>
							<td>${ bookInfo.downvote }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Hình ảnh</th>
							<td><img
								src="<c:url value="/file-upload/images/${ bookInfo.img }"></c:url>"
								width="145" height="232" /></td>
						</tr>
						<tr>
							<th style="width: 25%;">PDF</th>
							<td><c:if test="${ bookInfo.pdf == null }">PDF hiện tại không sẵn có</c:if>
								<c:if test="${ bookInfo.pdf != null }">
									<div>
										<button id="prev">Previous</button>
										<button id="next">Next</button>
										&nbsp; &nbsp; <span>Page: <span id="page_num"></span> /
											<span id="page_count"></span></span>
									</div>
									<canvas id="pdf"></canvas>
								</c:if></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="card-footer">
		<a class="btn btn-primary"
			href="<c:url value="/quan-tri/danh-sach-sach"></c:url>">Quay về
			danh sách</a> | <a class="btn btn-success"
			href="<c:url value="/quan-tri/chinh-sua-sach/${ bookInfo.ID }"></c:url>">Chỉnh
			sửa</a> | <a class="btn btn-success"
			href="<c:url value="/quan-tri/hinh-anh-cua-sach/${ bookInfo.ID }"></c:url>">Hình
			ảnh</a> | <a class="btn btn-success"
			href="<c:url value="/quan-tri/pdf-cua-sach/${ bookInfo.ID }"></c:url>">PDF</a>
		| <a class="btn btn-success"
			href="<c:url value="/quan-tri/tac-gia-cua-sach/${ bookInfo.ID }"></c:url>">Tác
			giả</a>
	</div>
</div>

<c:if test="${ bookInfo.pdf != null }">
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
		var url = "<c:url value="/file-upload/pdfs/${ bookInfo.pdf }"></c:url>";

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