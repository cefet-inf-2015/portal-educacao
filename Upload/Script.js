function mudaStatus(nome) {
			$(function () {
				$.ajax({
					url: 'Gerenciar.php',
					data: {
						nome: nome
					},
					dataType: 'json',
					success: function(data) {
						console.log('oi');
					},
					error: function(req, err) {
						console.log(err, req);
					}
				});
			});
} 