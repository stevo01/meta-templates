
# Overview 

this samples shows how to share files between two recipes

## generate-key-sample 
 the task do_compile() generates two files.
 secret.key.001 - contains a key and should be stored in sysroot and 
                  deployed to rootfs
 secret.key.002- contains a key and should be stored in sysroot and 
                 not deployed to rootfs

## use-key-sample 
 the task do_compile() read 
 - content of file secret.key.001 and copy it to file secret.key.003
 - content of file secret.key.002 and copy it to file secret.key.004         

## files and path 

find tmp-glibc/ | grep "secret.key"
tmp-glibc/sysroots-components/core2-64/generate-key-sample/usr/lib/keys/secret.key.001
tmp-glibc/sysroots-components/core2-64/generate-key-sample/usr/share/keys/secret.key.002
tmp-glibc/work/qemux86_64-oe-linux/turbo-image-minimal/1.0-r0/rootfs/usr/bin/secret.key.003
tmp-glibc/work/qemux86_64-oe-linux/turbo-image-minimal/1.0-r0/rootfs/usr/bin/secret.key.004
tmp-glibc/work/qemux86_64-oe-linux/turbo-image-minimal/1.0-r0/rootfs/usr/lib/keys/secret.key.001
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/image/usr/bin/secret.key.003
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/image/usr/bin/secret.key.004
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/secret.key.003
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/packages-split/use-key-sample/usr/bin/secret.key.003
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/packages-split/use-key-sample/usr/bin/secret.key.004
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/secret.key.004
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/package/usr/bin/secret.key.003
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/package/usr/bin/secret.key.004
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/recipe-sysroot/usr/lib/keys/secret.key.001
tmp-glibc/work/core2-64-oe-linux/use-key-sample/0.1-r0/recipe-sysroot/usr/share/keys/secret.key.002
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/sysroot-destdir/usr/lib/keys/secret.key.001
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/sysroot-destdir/usr/share/keys/secret.key.002
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/image/usr/lib/keys/secret.key.001
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/image/usr/share/keys/secret.key.002
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/secret.key.002
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/packages-split/generate-key-sample-sharedfiles/usr/share/keys/secret.key.002
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/packages-split/generate-key-sample-key/usr/lib/keys/secret.key.001
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/secret.key.001
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/package/usr/lib/keys/secret.key.001
tmp-glibc/work/core2-64-oe-linux/generate-key-sample/0.1-r0/package/usr/share/keys/secret.key.002


## relevant Variables
- STAGING_DIR 
- SYSROOT_DIRS 
- SYSROOT_DIRS_BLACKLIST
- SYSROOT_DIRS_NATIVE
- STAGING_DATADIR
- STAGING_BASELIBDIR
- STAGING_LIBDIR

## relevant tasks
- do_populate_sysroot
- do_prepare_recipe_sysroot


## bookmarks
 * https://docs.yoctoproject.org/2.6/dev-manual/dev-manual.html#new-sharing-files-between-recipes
 * https://docs.yoctoproject.org/2.6/ref-manual/ref-manual.html#var-STAGING_DIR


## notes
logfile shows that secret key was revovered from sstate cache 

'''
