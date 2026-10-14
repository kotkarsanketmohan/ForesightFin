function validateRegister() {
    const alertBox = document.getElementById("uiAlert");

    const password = document.querySelector('input[name="password"]').value;
    const confirmPassword = document.querySelector('input[name="confirmPassword"]').value;

    if (password !== confirmPassword) {
        alertBox.innerHTML = `
            <div class="alert alert-danger">
                Passwords do not match
            </div>`;
        return false;
    }

    return true;
}
