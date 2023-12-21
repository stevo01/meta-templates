SUMMARY = "read file from sysroot directory"
DESCRIPTION = "just a sample how to read a file from sysroot directory"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

DEPENDS = "generate-key-sample"

do_compile() {
    echo ${SHAREDKEY_FILENAME}

    SHARED_KEY=$(cat "${STAGING_DATADIR}/../../sysroot-only/keys/secret.key")
    echo $SHARED_KEY
    export SHARED_KEY
    echo  $SHARED_KEY > secretkey.txt
}

do_install() {      

        install -d ${D}${bindir}
        install secretkey.txt ${D}${bindir} 
}

