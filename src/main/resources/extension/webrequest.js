chrome.webRequest.onAuthRequired.addListener(function(details){
console.log(“chrome.webRequest.onAuthRequired event has fired”);
return {
authCredentials: {username: "public”, password: "Let$BeC001"}
};
},
{urls:[“https://bgp-qa.gds-govtech/”]},
[‘blocking’]);



