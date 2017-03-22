$(function() {

	// Vars.
	var $window = $(window), $body = $('body'), $wrapper = $('#wrapper');

	// Breakpoints.
	skel.breakpoints({
		xlarge : '(max-width: 1680px)',
		large : '(max-width: 1280px)',
		medium : '(max-width: 980px)',
		small : '(max-width: 736px)',
		xsmall : '(max-width: 480px)'
	});

	// Disable animations/transitions until everything's loaded.
	$body.addClass('is-loading');

	$window.on('load', function() {
		$body.removeClass('is-loading');
	});

	$window.on('load', function() {
		$("#locatorsDiv").fadeIn(1500).show();
		$("#queriesDiv").hide();
		$("#messagesDiv").hide();

		var selectedText = $("#fileTypeDropdown").val();
		loadDropdowns(selectedText);

		$("#fileTypeDropdown").on('change', function() {
			var selectedText = $(this).val();
			loadDropdowns(selectedText);
		});
	});

	function loadDropdowns(selectedText) {
		if (selectedText === "Locators") {
			$("#locatorsDiv").fadeIn(1500).show();
			$("#messagesDiv").hide();
			$("#queriesDiv").hide();

		} else if (selectedText === "Messages") {
			$("#messagesDiv").fadeIn(1500).show();
			$("#locatorsDiv").hide();
			$("#queriesDiv").hide();

		} else if (selectedText === "Queries") {
			$("#queriesDiv").fadeIn(1500).show();
			$("#locatorsDiv").hide();
			$("#messagesDiv").hide();
		}

	}

});