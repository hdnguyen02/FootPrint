const mapping = {
    A: 'Q', B: 'W', C: 'E', D: 'R', E: 'T', F: 'Y', G: 'U',
    H: 'I', I: 'O', J: 'P', K: 'A', L: 'S', M: 'D', N: 'F',
    O: 'G', P: 'H', Q: 'J', R: 'K', S: 'L', T: 'Z', U: 'X',
    V: 'C', W: 'V', X: 'B', Y: 'N', Z: 'M'
};

// bac su kien submit 
const formElement = document.querySelector("[data-monoalphabetic-form]")
const messageElement = document.querySelector("[data-message]")
const resultElement = document.querySelector("[data-result]")

formElement.addEventListener("submit", event => {
    event.preventDefault()
    let message = messageElement.value.toUpperCase()
    let result = ""
    // lặp qua mess
    // * làm thêm kiểm tra ký tự hoa và thường
    for (sub of message) {
        if (mapping[sub]) {
            result += mapping[sub]
        }
        else {
            result += sub
        }
    }
    console.log(result)
    resultElement.innerHTML = `
        <label for="exampleInputEmail1" class="form-label">Message</label>
        <textarea data-message type="text" class="form-control" id="exampleInputEmail1"
            aria-describedby="emailHelp" readonly>${result}</textarea>
    `
    // hiển thị lên. 
})


// bắc sự kiện 




