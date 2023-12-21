SUMMARY = "sysroot-only sample recipe"
DESCRIPTION = "sample: deploy a file to sysroot without copy to rootfs of target"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

do_compile() {
   echo "1234" > secret.key
   echo "5678" > testfile
}

do_install() {    
    # install to sysdir (testfile will be deployed to rootfs of target)
    install -d ${D}${datadir}/keys
    install testfile ${D}${datadir}/keys/testfile 


    # install to sysdir and allow other recipe to read/use the file
    # (will be not deployed to rootfs of target)
    install -d ${D}/sysroot-only/keys
    install secret.key ${D}/sysroot-only/keys
}

FILES:${PN} += "${datadir}/keys/testfile"