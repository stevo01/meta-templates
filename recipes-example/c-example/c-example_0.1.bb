SUMMARY = "C sample recipe"
DESCRIPTION = "just a sample how to create a recipe for C application"
HOMEPAGE = "https://www.devpool.net"
LICENSE = "MIT"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  c example receipe                          *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

do_display_banner[doc] = "just a test task"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello.c"

S = "${WORKDIR}"

do_compile() {
        ${CC} hello.c ${LDFLAGS} -o helloc
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 helloc ${D}${bindir}
}
