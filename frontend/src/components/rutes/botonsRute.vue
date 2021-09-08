<template>
    <div ref="outside" class="d-flex justify-content-end" style="position:absolute;right:0;">
        <div>
            <div class="m-3 p-2" @click="changeAddRoute" style="color:white;background:#37f185;border-radius:50%;">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                </svg>
            </div>
            <div @click="$emit('goToPublication')" class="m-3 p-2" style="color:white;background:#1DB2E5;border-radius:50%;">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-chat-text-fill" viewBox="0 0 16 16">
                    <path d="M16 8c0 3.866-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.584.296-1.925.864-4.181 1.234-.2.032-.352-.176-.273-.362.354-.836.674-1.95.77-2.966C.744 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7zM4.5 5a.5.5 0 0 0 0 1h7a.5.5 0 0 0 0-1h-7zm0 2.5a.5.5 0 0 0 0 1h7a.5.5 0 0 0 0-1h-7zm0 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4z"/>
                </svg>
            </div>
            <div @click="$emit('removeRute')" class="m-3 p-2 btn-remove" v-if="$cookies.get('token') && $cookies.get('token') === ruta.id_usuario">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                </svg>
            </div>
            <div @click="$emit('showBottonMenu')" class="m-3 p-2 btn-close">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-arrow-return-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M14.5 1.5a.5.5 0 0 1 .5.5v4.8a2.5 2.5 0 0 1-2.5 2.5H2.707l3.347 3.346a.5.5 0 0 1-.708.708l-4.2-4.2a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 8.3H12.5A1.5 1.5 0 0 0 14 6.8V2a.5.5 0 0 1 .5-.5z"/>
                </svg>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name : 'BotonsRute',
    props : {
        showBotonsRute : Boolean,
        ruta : Object,
    },
    methods : {
        changeAddRoute(){
            if(this.$cookies.get('token')){
                this.$store.dispatch('changeAddMetricaAction', this.ruta)
            } else {
                this.$router.push('/Login')
            }
        }
    }
}
</script>
<style scoped>
.btn-close{
    background:#2c3e50;
    border-radius:50%;
    color:white;
}
.btn-close:hover{
    background: rgb(134, 25, 25);
    cursor:pointer;
    transition: 650ms;
}
.btn-remove{
    background: rgb(134, 25, 25);
    border-radius:50%;
    color:white;
    cursor:pointer;
}
.btn-remove:hover {
    background: rgb(90, 13, 13);
    transition: 650ms;
}
</style>