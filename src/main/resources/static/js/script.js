document.addEventListener("DOMContentLoaded", () => {
  let duplicateCheck = false;
  let userId = document.querySelector("#userid");
  let signUpForm = document.querySelector("#signUpForm");
  let checkBtn = document.querySelector("#checkBtn");
  let pw = document.getElementById("pw");
  let pwCheck = document.getElementById("pwCheck");

  // message 요소를 한 번만 생성
  let pwCheckTxt = document.querySelector("ul.pw_check_txt");
  let message = document.createElement("div");
  message.id = "passwordMessage";
  if (pwCheckTxt) {
    pwCheckTxt.insertAdjacentElement("afterend", message);
  }
  function usernameChange() {
    duplicateCheck = false;
  }

  function valid(event) {
    if (!duplicateCheck) {
      alert("아이디 중복체크를 해주세요");
      event.preventDefault();
      return false;
    }
    return true;
  }

  function passwordCheck() {
    let pwValue = pw.value;
    let pwCheckValue = pwCheck.value;

    // 기존 메시지 내용 초기화
    message.textContent = "";

    if (pwValue === pwCheckValue) {
      message.textContent = "비밀번호가 일치합니다.";
      message.style.color = "#27984f";
    } else {
      message.textContent = "비밀번호가 일치하지 않습니다.";
      message.style.color = "#cf1e1e";
    }
  }

  // 중복 체크 함수
  async function check() {
    let userIdValue = userId.value;
    console.log(userIdValue);

    // 중복 체크 요청
    let response = await fetch(
      `/user/api/duplicateCheck?userid=${userIdValue}`,
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    console.log("response: ", response);

    let responseBody = await response.json();
    console.log(responseBody);

    if (responseBody.success) {
      alert(responseBody.data);
      duplicateCheck = true;
    } else {
      alert(responseBody.data);
      duplicateCheck = false;
    }
  }

  if (userId) {
    userId.addEventListener("change", usernameChange);
  }
  if (pw && pwCheck) {
    pw.addEventListener("change", passwordCheck);
    pwCheck.addEventListener("change", passwordCheck);
  }
  if (checkBtn) {
    checkBtn.addEventListener("click", check);
  }
  if (signUpForm) {
    signUpForm.addEventListener("submit", valid);
  }
});
