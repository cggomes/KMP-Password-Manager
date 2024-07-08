//
//  PasswordView.swift
//  iosApp
//
//  Created by Christian Gomes on 03/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SDWebImageSwiftUI

struct PasswordView: View {
    
    let passwordViewModel = PasswordViewModel()
    
    var body: some View {
        VStack(alignment: .leading) {
            plusButton
            title
            passwordList
        }
        .frame(maxWidth: .infinity, maxHeight: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/, alignment: .top)
        .padding(16)
    }
    
    var plusButton: some View {
        Image(systemName: "plus.circle")
            .resizable()
            .aspectRatio(contentMode: .fit)
            .frame(width: 24)
            .foregroundColor(.blue)
            .padding(.bottom, 8)
    }
    
    var title: some View {
        Text("Password")
            .font(.largeTitle)
            .bold()
    }
    
    var passwordList: some View {
        LazyVStack {
            ForEach(passwordViewModel.getPasswords(), id: \.self) { password in
                HStack(spacing: 0) {
                    WebImage(
                        url: URL(string: password.appLogo)
                    ) { result in
                        result.image?.resizable()
                    }
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 48, height: 48)
                    .padding(.trailing, 8)
                    VStack(alignment: .leading, spacing: 0) {
                        Text(password.title)
                            .bold()
                        Text(password.username)
                            .opacity(0.6)
                    }
                    Spacer()
                    Image(systemName: "ellipsis")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 24)
                        .opacity(0.6)
                }
            }
        }
    }
}

#Preview {
    PasswordView()
}
