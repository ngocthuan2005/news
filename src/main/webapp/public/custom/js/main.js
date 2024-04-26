$(".toggle-password").click(function() {
	$(this).toggleClass("fa-eye fa-eye-slash");
	var input = $($(this).attr("toggle"));
	if (input.attr("type") == "password") {
		input.attr("type", "text");
	} else {
		input.attr("type", "password");
	}
});

$("#login").click(function() {
	const email = $("#email").val();
	const password = $("#password-field").val();
	location.href = `http://localhost:8080/TinTuc/login-signup/login/email=${email}&password=${password}`;
});

function comment(newSlug, idUser) {
	const contentComment = $("#comment").val();
	location.href = `http://localhost:8080/TinTuc/comments/${newSlug}/${idUser}/${contentComment}`;
}

$(document).ready(function() {
	$(document).on("submit", "#form", function() {
		let select = true;
		if ($("#password").val().length < 8) {
			$("#error").text("Mật khẩu phải từ 8 ký tự trở lên");
			select = false;
		} else if (
			$("#role").val() == 0 ||
			$("#danhmuc").val() == 0 ||
			$("#thuoctinh".val() == 0)
		) {
			$("#error").text("Vui lòng chọn thông tin phù hợp");
			select = false;
		}
		return select;
	});
});

$("#title").on("keyup", function() {
	//Lấy text từ thẻ input title
	let title = $(this).val();

	//Đổi chữ hoa thành chữ thường
	let slug = title.toLowerCase();

	let randomLink = Math.random() * 100;

	slug += " " + randomLink;
	if (!title.trim().length) {
		slug = "";
	}

	//Đổi ký tự có dấu thành không dấu
	slug = slug.replace(/á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ/gi, "a");
	slug = slug.replace(/é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ/gi, "e");
	slug = slug.replace(/i|í|ì|ỉ|ĩ|ị/gi, "i");
	slug = slug.replace(/ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ/gi, "o");
	slug = slug.replace(/ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự/gi, "u");
	slug = slug.replace(/ý|ỳ|ỷ|ỹ|ỵ/gi, "y");
	slug = slug.replace(/đ/gi, "d");
	//Xóa các ký tự đặt biệt
	slug = slug.replace(
		/\`|\~|\!|\@|\#|\||\$|\%|\^|\&|\*|\(|\)|\+|\=|\,|\.|\/|\?|\>|\<|\'|\"|\:|\;|_/gi,
		""
	);
	//Đổi khoảng trắng thành ký tự gạch ngang
	slug = slug.replace(/ /gi, "-");
	//Đổi nhiều ký tự gạch ngang liên tiếp thành 1 ký tự gạch ngang
	//Phòng trường hợp người nhập vào quá nhiều ký tự trắng
	slug = slug.replace(/\-\-\-\-\-/gi, "-");
	slug = slug.replace(/\-\-\-\-/gi, "-");
	slug = slug.replace(/\-\-\-/gi, "-");
	slug = slug.replace(/\-\-/gi, "-");
	//Xóa các ký tự gạch ngang ở đầu và cuối
	slug = "@" + slug + "@";
	slug = slug.replace(/\@\-|\-\@|\@/gi, "");
	//In slug ra textbox có id “slug”
	$("#slug").val(`${slug}`);
});

$(document).ready(function() {
	$("#content").summernote();
});

$("#danhmuc").change(function(e) {
	var idDanhMuc = $("#danhmuc").val();
	var action = $(this).attr("id");
	var result = "";
	if (action == "danhmuc") {
		result = "thuoctinh";
	}
	if (idDanhMuc != 0) {
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/TinTuc/admin/new-admin/write-new/selectproperty/",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: { category: idDanhMuc },
			dataType: "text",

			success: function(data) {
				$("#" + result).html(data);
			},
		});
	}
});

//check pass
$(document).on("submit", "#frmSignUp", function() {
	let select = true;
	let password = $("#password").val();
	let repassword = $("#repassword").val();
	if (password.length < 8) {
		$("#error").text("Mật khẩu phải từ 8 ký tự trở lên");
		select = false;
	} else if (password != repassword) {
		$("#error").text("Mật khẩu không trùng khớp");
		select = false;
	}
	return select;
});

function toast({ title = "", message = "", type = "info", duration = 3000 }) {
	const main = document.getElementById("toast");
	const icons = {
		success: "fa-check",
		warning: "fa-triangle-exclamation",
		danger: "fa-circle-xmark",
		info: "fa-circle-info",
	};

	const icon = icons[type];
	const delay = (duration / 1000).toFixed(2); //lấy thời gian sau dấu thập phân thứ 2.
	if (main) {
		//Tạo ra thẻ div toast
		const toast = document.createElement("div");

		//auto remove
		const autoRemoveID = setTimeout(() => {
			main.removeChild(toast);
		}, duration + 1000);

		//Click close
		toast.onclick = function(e) {
			//Tìm class và tất cả con trong class toast__close.
			//Nếu không thấy thì tìm ra thẻ cha.
			if (e.target.closest(".toast__close")) {
				main.removeChild(toast);
				clearTimeout(autoRemoveID);
			}
		};

		//add thẻ div vô trong html
		toast.classList.add("toast", `toast--${type}`);
		//add hiệu ứng animotion vô trong html
		toast.style.animation = `
        slideInLeft ease 2s, fadeOut linear ${delay}s forwards
      `;
		toast.innerHTML = `
        <div class="toast__icon">
          <i class="fa-solid ${icon}"></i>
        </div>
        <div class="toast__body">
          <h3 class="toast__title">${title}</h3>
          <p class="toast__message">${message}</p>
        </div>
        <div class="toast__close">
          <i class="fa-solid fa-xmark"></i>
        </div>
      `;
		main.appendChild(toast);
	}
}

function showSuccessToast() {
	toast({
		title: "Thành công",
		message: "Bạn đã đăng nhập thành công.",
		type: "success",
		duration: 5000,
	});
}

$("#btnAddNew").click(() => {
	let title = $("#title").val();
	let slug = $("#slug").val();
	let tomtat = $("#tomtat").val();
	let danhmuc = $("#danhmuc").val();
	let thuoctinh = $("#thuoctinh").val();
	let content = $("#content").val();
	let author = $("#author").val();
	let id_role = $("#id_role").val();
	let file = $("#hinhanh")[0].files[0];
	if (title.length == 0) {
		$("#error").text("Xin vui lòng nhập tiêu đề bài viết");
	} else if (tomtat.length == 0) {
		$("#error").text("Xin vui long nhập tóm tắt");
	} else if (danhmuc == 0) {
		$("#error").text("Xin vui lòng chọn danh mục bài viết");
	} else if (thuoctinh == 0) {
		$("#error").text("Xin vui lòng chọn thuộc tính bài viết");
	} else if (typeof file === "undefined") {
		$("#error").text("Xin vui lòng chọn file");
	} else if (title.length == 0) {
		$("#error").text("Xin vui long nhập tiêu đề");
	} else if (content.length == 0) {
		$("#error").text("Xin vui lòng nhập nội dung bài viết");
	} else {
		$("#error").text("");
		let base64String;
		let fileName = file.name;
		let reader = new FileReader();
		reader.readAsDataURL(file);
		
		reader.onload = () => {
			console.log(reader.result);
			base64String = reader.result.replace("data:", "").replace(/^.+,/, "");
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/TinTuc/admin/new-admin/write-new/addNew/",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				data: {
					title: title,
					slug: slug,
					tomtat: tomtat,
					content: content,
					id_role: id_role,
					author: author,
					hinhanh: fileName,
					thuoctinh: thuoctinh,
					danhmuc: danhmuc,
					base64String: base64String,
				},
				success: () => {
					showSuccessToast();
				}
			});
		};
	}
});


async function getData(url = '') {
	let response = await fetch(url, {
		method: 'GET',
	});
	return response.json();
}

function showPosition(position) {
	let api = `https://api.openweathermap.org/data/2.5/weather?lat=${position.coords.latitude}&lon=${position.coords.longitude}&appid=04970e49d844f27a9ecdddae8c588a72`;
	getData(api).then((data) => {
		let city = data.name;
		console.log(api);
		let temp = (data.main.temp - 273.15).toFixed();
		$('#container__location').text(city);
		$('#container__tempera').text(temp);
	});
}
function showMain() {
	let date = new Date();
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(showPosition);
	}
	let today = `Hôm nay ${date.getDate()}-${(date.getMonth() + 1)}-${date.getFullYear()}`;
	$('#container__date').text(today);
}

showMain();