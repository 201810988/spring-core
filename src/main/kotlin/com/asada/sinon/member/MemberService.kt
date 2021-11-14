package com.asada.sinon.member

interface MemberService {

    fun join(member: Member)

    fun findMember(memberId: Long): Member?
}