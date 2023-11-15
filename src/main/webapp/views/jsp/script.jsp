<script>
    document.getElementById('openFormBtn').addEventListener('click', function () {
        document.getElementById('formContainer').style.display = 'block';
        document.getElementById('overlay').style.display = 'block';
    });

    document.getElementById('closeFormBtn').addEventListener('click', function () {
        document.getElementById('formContainer').style.display = 'none';
        document.getElementById('overlay').style.display = 'none';
    });
</script>