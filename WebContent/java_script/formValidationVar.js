/**
 * 
 */
var confPwd = {
            validators: {
                notEmpty: {
                    message: 'The password is required'
                },
                   identical: {
                            field: 'newPassword',
                            message: 'The new password and its confirm password are not the same'
                        }
                    
	}
        }, passwordValidators = {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
    	}
            },
            statusValidators = {
                    validators: {
                        notEmpty: {
                            message: 'The FIELD is required'
                        }
        	}
                },
               emailvalidator= {

                    validators: {
                    	notEmpty: {
                            message: 'The FIELD is required'
                        },
                        emailAddress: {
                            message: 'The value is not a valid email address'
                        },
                        regexp: {
                            regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                            message: 'The value is not a valid email address'
                        }
                    }
                }
       