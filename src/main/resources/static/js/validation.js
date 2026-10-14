function showAlert(message, type = "success") {
    const alertBox = document.getElementById("uiAlert");
    if (!alertBox) return;

    alertBox.className = "ui-alert " + type;
    alertBox.innerText = message;
    alertBox.style.display = "block";

    setTimeout(() => {
        alertBox.style.display = "none";
    }, 2500);
}

function validateForm(formId, successMessage) {
    const form = document.getElementById(formId);
    let valid = true;

    form.querySelectorAll("input").forEach(input => {
        if (input.value.trim() === "") {
            input.classList.add("is-invalid");
            valid = false;
        } else {
            input.classList.remove("is-invalid");
        }
    });

    if (!valid) {
        showAlert("Please fill all fields", "error");
        return false;
    }

    showAlert(successMessage, "success");
    return false; // prevent actual submit (UI phase)
}

function updateRow() {
    showAlert("Update clicked (UI only)");
}

function deleteRow() {
    if (confirm("Are you sure you want to delete this entry?")) {
        showAlert("Entry deleted (UI only)");
    }
}
