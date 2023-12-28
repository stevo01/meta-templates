SUMMARY = "sysroot-only sample recipe"
DESCRIPTION = "sample: deploy a file to sysroot without copy to rootfs of target"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

PACKAGES += "${PN}-sharedfiles ${PN}-key"

do_compile() {
   echo "1234" > secret.key.001
   echo "5678" > secret.key.002
}

do_install() {    

    # install to libdir (secret.key.001 will be deployed to rootfs of target)
    install -d ${D}${libdir}/keys
    install secret.key.001 ${D}${libdir}/keys

    # install to datadir and allow other recipe to read/use the file
    # (will be not deployed to rootfs of target)
    install -d ${D}${datadir_native}/keys
    install secret.key.002 ${D}${datadir_native}/keys
}

FILES_${PN}-key += "${libdir}/keys/secret.key.001"
FILES_${PN}-sharedfiles += "${datadir_native}/keys/secret.key.002"

