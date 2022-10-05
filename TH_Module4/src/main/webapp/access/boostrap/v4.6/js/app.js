class App {
    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: "warning",
            text: "Are you sure you want to delete the selected data ?",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, delete it !"
        });
    };

    static showConfirmDialog(message,t) {
        return Swal.fire({
            title: t,
            icon: "warning",
            text: message,
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, Sign in Now !"
        });
    };

    static showSuccessAlert(t) {
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: t,
            showConfirmButton: true,
            timer: 5000,
        })
    };

    static showErrorAlert(t) {
        Swal.fire({
            icon: "error",
            title: "Warning",
            text: t,
        });
    };

    static toastSuccess(t) {
        iziToast.success({
            title: 'OK',
            position: 'bottomLeft',
            timeout: 1500,
            message: t
        });
    }

    static toastError(t) {
        iziToast.error({
            title: 'ERROR',
            position: 'bottomLeft',
            timeout: 2000,
            message: t
        });
    }
}