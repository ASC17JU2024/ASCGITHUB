function .a() {
    clear
    eval "$(ssh-agent -s)";
    ssh-add ~/.ssh/id_rsa_LIVEGIT3;
    cd /C/Users/Zyan/Desktop/ASCGITHUB/ASCGITHUB
    clear
    echo "git add ."
    git add .
    # The -z switch = true if "$1" is a null string.
    if [ -z "$1" ]
    then
        # git commit -a -m "commit"
        echo "git commit -a -m \"commit\""
        git commit -a -m "commit 😊"
    else
        # git commit -a -m "$1"
        echo "git commit -a -m \"$1\""
        git commit -a -m "$1"
    fi;
    echo "git push"
    git push
}
