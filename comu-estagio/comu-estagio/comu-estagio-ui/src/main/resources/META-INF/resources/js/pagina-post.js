try {
	Typekit.load();
} catch (e) {
}
$(document).ready(function() {
	$('.card-module').prepend('<div class="bg-img"></div>');
	var $bg = $('.bg-img');
	var $meImg = $('.me img');
	var $disp_name = $('.info .display-name');
	var $email = $('.info .email span')
	var $fb = $('#facebook-lnk');
	var $tw = $('#twitter-lnk');
	var $ln = $('#linked-lnk');
	var email = 'beau@dentedreality.com.au';
	var gravatarUrl = 'http://en.gravatar.com/';
	var hash;

	$('#yours').on('submit', function(e) {
		e.preventDefault();
		$('.social-links a').hide();
		email = $('#email-input').val();
		hash = md5(email);
		var profileUrl = gravatarUrl + hash + ".json";
		$.ajax({
			type : 'GET',
			dataType : 'jsonp',
			jsonpCallback : 'fillCard',
			url : profileUrl,
			success : function(responseData) {
				fillCard(responseData)
			},
			error : function(xhr, textStatus, errorThrown) {
			}
		});
	});

	function fillCard(profile) {
		var entry = profile.entry[0];
		var newImg = gravatarUrl + 'avatar/' + hash + '?s=240';
		var newBg = gravatarUrl + 'avatar/' + hash + '?s=400';
		var accounts = entry.accounts;
		$disp_name.hide().text(entry.displayName).fadeIn(200);
		$email.hide().text(email).fadeIn(200);
		$meImg.hide().attr('src', newImg).fadeIn(200);
		$bg.css('background', 'url(' + newBg + ')');

		for (var i = 0; i < accounts.length; i++) {
			if (accounts[i].shortname == 'facebook') {
				$fb.attr('href', accounts[i].url).fadeIn(200);
			}
			if (accounts[i].shortname == 'twitter') {
				$tw.attr('href', accounts[i].url).fadeIn(200);
			}
			if (accounts[i].shortname == 'linkedin') {
				$ln.attr('href', accounts[i].url).fadeIn(200);
			}
		}
	}

	/* trigger initial demo */
	$('#email-input').val('beau@dentedreality.com.au');
	$('#generate-btn').click();
	$('#email-input').val('');

});