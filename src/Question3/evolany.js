// size = sequenced hex number
// fileName = name of file to be downloaded
function generateRandomData(fileName, size) {
  // check for incorrect or null input
  if (size == null || size < 0 || size.toString().trim().length === 0) return;
  let newSize = parseInt(size, 16);
  // check if input is at least one megabyte
  if (newSize < 1024) {
    console.log(
      `Input must be in megabytes! Current size is: ${newSize}\n Size must be >= 1024`
    );
    // disable <a> tag
    link.href = "javascript:void(0)";
    return;
  } else {
    // convert into bytes
    newSize *= 1024;
    let blob = new Blob([new ArrayBuffer(newSize)], {
      type: "application/octet-stream",
    });
    // append the link to the <a> tag and set the name of the downloaded file to fileName
    link.href = URL.createObjectURL(blob);
    link.download = fileName;
  }
}
generateRandomData('sample.txt','f4240')