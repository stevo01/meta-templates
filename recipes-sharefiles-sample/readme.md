
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
