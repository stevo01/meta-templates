SUMMARY = "read file from sysroot directory"
DESCRIPTION = "just a sample how to read a file from sysroot directory"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

DEPENDS = "generate-key-sample"

do_compile() {
    echo "STAGING_DATADIR = ${STAGING_DATADIR}"
    echo "STAGING_DIR = ${STAGING_DIR}"
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}"

    SHARED_KEY_001=$(cat "${STAGING_LIBDIR}/keys/secret.key.001")
    echo "SHARED_KEY_001 = $SHARED_KEY_001"
    echo $SHARED_KEY_001 > secret.key.003

    SHARED_KEY_002=$(cat "${STAGING_DATADIR}/keys/secret.key.002")
    echo "SHARED_KEY_002 = $SHARED_KEY_002"
    echo $SHARED_KEY_002 > secret.key.004
}

do_install() {
        install -d ${D}${bindir}
        install secret.key.003 ${D}${bindir} 
        install secret.key.004 ${D}${bindir} 
}

