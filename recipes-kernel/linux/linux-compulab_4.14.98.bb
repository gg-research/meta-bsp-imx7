SUMMARY = "CompuLab 4.14.98 kernel"
DESCRIPTION = "Linux kernel for CompuLab imx7 boards."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-imx-src-${PV}.inc
LOCALVERSION = "-cl-3.0"

DEPENDS += "lzop-native bc-native"

DEFAULT_PREFERENCE = "1"

include linux-compulab-4.14.98/linux-compulab_cl-som-imx7.inc

addtask copy_defconfig after do_unpack before do_preconfigure
do_copy_defconfig () {
    echo ${S}
    echo ${B}
    install -d ${B}
    mkdir -p ${B}
#    cp ${S}/arch/arm/configs/compulab_imx7_defconfig ${B}/.config
#    cp ${S}/arch/arm/configs/compulab_imx7_defconfig ${B}/../defconfig
}

COMPATIBLE_MACHINE = "cl-som-imx7"
# EXTRA_OEMAKE_append_mx7 = " ARCH=arm"
