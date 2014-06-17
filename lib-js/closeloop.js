var req = Java.type("org.wingsource.closeloop.require.Require");
function require(module) {
	req.load(module);
}