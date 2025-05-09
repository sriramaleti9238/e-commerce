document.addEventListener('DOMContentLoaded', function() {
    // Product image error handling
    const productImages = document.querySelectorAll('.product-img');
    productImages.forEach(img => {
        img.onerror = function() {
            this.src = 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fstock.adobe.com%2Fsearch%2Fimages%3Fk%3Dno%2Bimage%2Bavailable&psig=AOvVaw0C-nFzR6J_Gf1MZtC3iyEZ&ust=1746636041364000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPjU8bikj40DFQAAAAAdAAAAABAE';
        };
    });

    // Form validation
    const forms = document.querySelectorAll('.needs-validation');

    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }

            form.classList.add('was-validated');
        }, false);
    });

    // Confirm delete
    const deleteButtons = document.querySelectorAll('.btn-delete');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            if (!confirm('Are you sure you want to delete this product?')) {
                event.preventDefault();
            }
        });
    });

    // Auto-hide alerts after 5 seconds
    setTimeout(function() {
        const alerts = document.querySelectorAll('.alert-dismissible');
        alerts.forEach(alert => {
            const bsAlert = new bootstrap.Alert(alert);
            bsAlert.close();
        });
    }, 5000);

    // Price formatting
    const priceElements = document.querySelectorAll('.format-price');
    priceElements.forEach(element => {
        const price = parseFloat(element.textContent);
        if (!isNaN(price)) {
            element.textContent = price.toLocaleString('en-US', {
                style: 'currency',
                currency: 'USD'
            });
        }
    });
});
