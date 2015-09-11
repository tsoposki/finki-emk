WebInvoicingApp.factory('authProvider', function() {
  var user;
  return {
    setUser : function(aUser){
      user = aUser;
    },
    isLoggedIn : function(){
      return(user)? user : false;
    }
  };
});
