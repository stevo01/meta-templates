SUMMARY = "read file from sysroot directory"
DESCRIPTION = "just a sample how to read a file from sysroot directory"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

# define inter-task dependencies
do_patch[depends] += "generate-key-sample:do_populate_sysroot" 

do_patch_extra (){
    # copy the files from staging to source code "S"
    mkdir -p ${S}/keys
    cp ${STAGING_LIBDIR}/keys/secret.key.001   ${S}/keys/secret.key.001 
    cp ${STAGING_DATADIR}/keys/secret.key.002  ${S}/keys/secret.key.002
}

do_patch_append () {
    bb.build.exec_func('do_patch_extra', d)   
}

do_compile() {
    echo "STAGING_DATADIR = ${STAGING_DATADIR}"
    echo "STAGING_DIR = ${STAGING_DIR}"
    echo "STAGING_LIBDIR = ${S}"

    SHARED_KEY_001=$(cat "${S}/keys/secret.key.001")
    echo "SHARED_KEY_001 = $SHARED_KEY_001"

    SHARED_KEY_002=$(cat "${S}/keys/secret.key.002")
    echo "SHARED_KEY_002 = $SHARED_KEY_002"


}

do_install() {
        install -d ${D}${bindir}/keys/
        install ${S}/keys/secret.key.001 ${D}${bindir}/keys/secret.key.003 
        install ${S}/keys/secret.key.002 ${D}${bindir}/keys/secret.key.004 
}

